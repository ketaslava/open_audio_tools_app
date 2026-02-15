package com.ktvincco.openaudiotools.domain


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
    private val promptReviewAfterUsageTime = 900 // 15 min
    private val reviewPromptCooldownTime = 2700 // 45 min
    private val updateTimeStep = 5


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
            if (data["formType"] == "feedbackText") {
                var text = data["textInput1"] ?: ""
                // Sanitize string
                text = text.trim()
                    .replace(Regex("[^\\p{L}\\p{N}\\p{P}\\p{Z}\\n\\t]"), " ")
                    .replace(Regex("[{}\\[\\]\"']"), " ")
                    .replace(Regex("[\\t ]+"), " ")
                    .replace(Regex("\\n{3,}"), "\n\n")
                    .take(8192)
                database.saveString("unsentFeedbackText", text)
            }
            if (data["formType"] == "feedbackRating") {
                database.saveString("unsentFeedbackRating", data["starsCount"] ?: "0")
            }
        }

        // Dialog closure processing
        modelData.assignReviewDialogWasCompletedCallback { exitPoint ->
            if (exitPoint == "starRating") {
                database.saveString("isReviewCompleted", "Yes")
                environmentConnector.promptUserToMakeAStoreReview()
            }
            if (exitPoint == "feedbackForm") {
                database.saveString("isReviewCompleted", "Yes")
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


    private fun checkUnsentFeedback() {
        val unsentFeedbackText = database.loadString("unsentFeedbackText") ?: ""
        if (unsentFeedbackText != "") {
            telemetry.sendStandardStatement(mapOf(
                "statementType" to "userFeedback",
                "feedbackType" to "Text",
                "text" to unsentFeedbackText
            )) { result ->
                if (result) {
                    database.saveString("unsentFeedbackText", "")
                }
            }
        }
        val unsentFeedbackRating = database.loadString("unsentFeedbackRating") ?: ""
        if (unsentFeedbackRating != "") {
            telemetry.sendStandardStatement(mapOf(
                "statementType" to "userFeedback",
                "feedbackType" to "5StarRating",
                "rating" to unsentFeedbackRating
            )) { result ->
                if (result) {
                    database.saveString("unsentFeedbackRating", "")
                }
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
                checkUnsentFeedback()
            }
        }
    }


    fun initialize() {
        enableUpdater()
    }
}