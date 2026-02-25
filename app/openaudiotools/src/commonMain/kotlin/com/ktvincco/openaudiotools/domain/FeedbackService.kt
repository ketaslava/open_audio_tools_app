package com.ktvincco.openaudiotools.domain


import com.ktvincco.openaudiotools.Configuration
import com.ktvincco.openaudiotools.data.Database
import com.ktvincco.openaudiotools.data.EnvironmentConnector
import com.ktvincco.openaudiotools.data.Logger
import com.ktvincco.openaudiotools.presentation.ModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch


class FeedbackService (private val modelData: ModelData,
                       private val logger: Logger,
                       private val database: Database,
                       private val telemetry: Telemetry,
                       private val environmentConnector: EnvironmentConnector ) {

    // Coroutines
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var updaterJob: Job? = null


    // Settings
    private val isAlwaysShowReviewDialogForDebug = false // false
    private val promptReviewAfterUsageTime = 900 // 900 (15 min)
    private val reviewPromptCooldownTime = 2700 // 2700 (45 min)
    private val updateTimeStep = 5


    // Variables
    private var isSendingData = false


    private fun updateRequestToLeaveARatingAndReview() {

        // Check review process is not completed
        if (database.loadString("isReviewCompleted") == "Yes" &&
            !isAlwaysShowReviewDialogForDebug) return

        // Check dialog state
        if (modelData.reviewDialogState.value != "Closed") return

        // Check is not recording
        if (modelData.recordingState.value) return

        // Check usage time > 15 min
        val usageTime = database.loadString("usageTime")?.toInt() ?: 0
        if (usageTime < promptReviewAfterUsageTime &&
            !isAlwaysShowReviewDialogForDebug) return

        // Check cooldown time (12 hours) is over
        val cooldownTime = database.loadString("reviewDialogCooldownUntil")?.toInt() ?: 0
        if (cooldownTime > (System.currentTimeMillis() / 1000).toInt() &&
            !isAlwaysShowReviewDialogForDebug) return

        // Feedback form receiver
        modelData.assignFormSubmittedCallback { data ->
            if (data["formType"] == "userFeedbackFormWith5StarRatingAndText") {

                // Process rating
                database.saveString(
                    "userFeedbackForm5StarRating", data["5StarRating"] ?: "0")

                // Process text
                var text = data["text"] ?: ""
                // Sanitize string
                text = text.trim()
                    .replace(Regex("[^\\p{L}\\p{N}\\p{P}\\p{Z}\\n\\t]"), " ")
                    .replace(Regex("[{}\\[\\]\"']"), " ")
                    .replace(Regex("[\\t ]+"), " ")
                    .replace(Regex("\\n{3,}"), "\n\n")
                    .take(8192)
                database.saveString("userFeedbackFormText", text)

                // Set flag
                database.saveString("isWeHaveUnsentUserFeedbackFormWith5StarRatingAndText", "Yes")
            }
        }

        // Dialog closure processing
        modelData.assignReviewDialogWasCompletedCallback { exitPoint ->
            if (exitPoint == "feedbackForm") {
                database.saveString("isReviewCompleted", "Yes")
                if (Configuration.IS_STORE_RELEASE) {
                    environmentConnector.openWebLink(Configuration.STORE_PAGE_URL)
                }
            }
            if (exitPoint == "Later") {
                database.saveString("reviewDialogCooldownUntil",
                    ((System.currentTimeMillis() / 1000).toInt() +
                            reviewPromptCooldownTime).toString())
            }
        }

        // Open dialog
        modelData.setReviewDialogState("DoYouEnjoyUsingThisApp")
    }


    private fun checkUnsentFeedbackForms() {

        // Get Flag
        val unsentUserFeedbackFormFlag = database.loadString(
            "isWeHaveUnsentUserFeedbackFormWith5StarRatingAndText") ?: ""

        // Check unsent status
        if (unsentUserFeedbackFormFlag == "Yes") {
            // Check state
            if (isSendingData) { return }
            // Sent data
            isSendingData = true
            telemetry.sendStandardStatement(mapOf(
                "statementType" to "userFeedbackFormWith5StarRatingAndText",
                "5StarRating" to (database.loadString("userFeedbackForm5StarRating") ?: "0"),
                "text" to (database.loadString("userFeedbackFormText") ?: "Error"),
            )) { result ->
                if (result) {
                    // Set flag
                    database.saveString("isWeHaveUnsentUserFeedbackFormWith5StarRatingAndText", "No")
                }
                isSendingData = false
            }
        }
    }


    private fun enableUpdater() {

        // Prevent double start
        if (updaterJob != null) return

        updaterJob = coroutineScope.launch {
            while (true) {
                delay((updateTimeStep * 1000).toLong())
                ensureActive()

                // Update Feedback Prompts
                updateRequestToLeaveARatingAndReview()
                checkUnsentFeedbackForms()
            }
        }
    }


    fun initialize() {
        enableUpdater()
    }
}