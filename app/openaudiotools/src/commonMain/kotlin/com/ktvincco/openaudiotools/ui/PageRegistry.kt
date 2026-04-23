package com.ktvincco.openaudiotools.ui

import androidx.compose.runtime.Composable
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.*
import com.ktvincco.openaudiotools.ui.components.PageWithBottomControls
import com.ktvincco.openaudiotools.ui.pages.*
import com.ktvincco.openaudiotools.ui.user_guide_pages.FrequentlyAskedQuestions
import com.ktvincco.openaudiotools.ui.user_guide_pages.GenderAffirmingVoicetrainingGuide
import com.ktvincco.openaudiotools.ui.user_guide_pages.TheGuideIsFinishedPage
import com.ktvincco.openaudiotools.ui.user_guide_pages.UserGuide
import com.ktvincco.openaudiotools.ui.user_guide_pages.GeneralVoicetrainingGuide
import com.ktvincco.openaudiotools.ui.user_guide_pages.SoundAnalysisGuide


/**
 * The Single Source of Truth for Page Navigation.
 * To add a new page, simply add a new entry to the [pages] map.
 */


object PageRegistry {

    data class PageInfo(
        val displayName: String,
        val draw: @Composable (ModelData) -> Unit
    )

    private val pages = mapOf(

        // Pages
        "Dashboard" to PageInfo("Dashboard") { Dashboard(it).Draw() },
        "Settings" to PageInfo("Settings") { SettingsPage(it).Draw() },
        "Recordings" to PageInfo("Recordings") { Recordings(it).Draw() },
        "Reading" to PageInfo("Reading") { Reading(it).Draw() },
        
        // Analysis Pages
        "AllInfo" to PageInfo("All Info") { PageWithBottomControls(it).Draw(AllInfo(it).content()) },
        "SpectrumInfo" to PageInfo("Spectrum") { PageWithBottomControls(it).Draw(SpectrumInfo(it).content()) },
        "SpeakerVoice" to PageInfo("Speaker Voice") { PageWithBottomControls(it).Draw(SpeakerVoice(it).content()) },
        "Singing" to PageInfo("Singing") { PageWithBottomControls(it).Draw(Singing(it).content()) },
        "PitchAndResonance" to PageInfo("Pitch And Resonance") { PageWithBottomControls(it).Draw(PitchAndResonance(it).content()) },
        "VoiceSmoothness" to PageInfo("Voice Smoothness") { PageWithBottomControls(it).Draw(VoiceSmoothness(it).content()) },
        "FeminineVoice" to PageInfo("Feminine Voice") { PageWithBottomControls(it).Draw(FeminineVoice(it).content()) },
        "FeminineVoiceResonance" to PageInfo("Feminine Voice Resonance") { PageWithBottomControls(it).Draw(FeminineVoiceResonance(it).content()) },
        "MasculineVoice" to PageInfo("Masculine Voice") { PageWithBottomControls(it).Draw(MasculineVoice(it).content()) },
        "MasculineVoiceResonance" to PageInfo("Masculine Voice Resonance") { PageWithBottomControls(it).Draw(MasculineVoiceResonance(it).content()) },

        // User Guide Pages
        "FrequentlyAskedQuestions" to PageInfo("FAQs") { FrequentlyAskedQuestions(it).Draw() },
        "UserGuide" to PageInfo("User Guide") { UserGuide(it).Draw() },
        "SoundAnalysisGuide" to PageInfo("Sound Analysis Guide") { SoundAnalysisGuide(it).Draw() },
        "GeneralVoicetrainingGuide" to PageInfo("Voicetraining Guide") { GeneralVoicetrainingGuide(it).Draw() },
        "GenderAffirmingVoicetrainingGuide" to PageInfo("Gender Affirming Voicetraining Guide") { GenderAffirmingVoicetrainingGuide(it).Draw() },
        "TheGuideIsFinishedPage" to PageInfo("The Guide is Finished") { TheGuideIsFinishedPage(it).Draw() },
        )

    @Composable
    fun DrawPage(id: String, modelData: ModelData) {
        pages[id]?.draw?.invoke(modelData) ?: Dashboard(modelData).Draw()
    }

    fun getDisplayName(id: String): String {
        return pages[id]?.displayName ?: id
    }
}
