package com.ktvincco.openaudiotools.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.ui.basics.Popup
import com.ktvincco.openaudiotools.ui.pages.Dashboard
import com.ktvincco.openaudiotools.ui.pages.Recordings
import com.ktvincco.openaudiotools.ui.screens.AccessDeniedScreen
import com.ktvincco.openaudiotools.ui.screens.FirstStartScreen
import com.ktvincco.openaudiotools.ui.screens.LegalInfoScreen
import com.ktvincco.openaudiotools.ui.screens.LoadingScreenOverlay
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.AllInfo
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.FeminineVoice
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.FeminineVoiceResonance
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.MasculineVoice
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.MasculineVoiceResonance
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.PitchAndResonance
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.Singing
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.SpeakerVoice
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.SpectrumInfo
import com.ktvincco.openaudiotools.ui.analysis_mode_pages.VoiceSmoothness
import com.ktvincco.openaudiotools.ui.components.HelpMenu
import com.ktvincco.openaudiotools.ui.components.MainMenu
import com.ktvincco.openaudiotools.ui.components.PageWithBottomControls
import com.ktvincco.openaudiotools.ui.components.ReviewForm
import com.ktvincco.openaudiotools.ui.pages.Reading
import com.ktvincco.openaudiotools.ui.pages.SettingsPage
import com.ktvincco.openaudiotools.ui.pages.VoiceChangeGuidelines
import com.sun.jdi.InterfaceType


class UserInterface (
    private val modelData: ModelData,
) {

    @Composable
    fun InterfaceRoot() {
        Column (
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(ColorPalette.getBackgroundColor()),
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                InterfaceOrigin()
            }
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                BottomSpace()
            }
        }
    }


    @Composable
    fun BottomSpace() {
        Box(
            Modifier
                .fillMaxWidth()
                .background(ColorPalette.getBlockColor())
        ) {
            // Banner AD
            modelData.bannerAdBlock.collectAsState().value()
        }
    }


    @Composable
    fun InterfaceOrigin() {
        // UI refresh
        val refreshKey = modelData.refreshKey.collectAsState().value
        key(refreshKey) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(ColorPalette.getBackgroundColor()),
            ) {
                // UI switch
                val isShowUi = modelData.isShowUi.collectAsState().value
                if (!isShowUi) {
                    return@Box
                }

                // Front screens

                if (modelData.legalInfoScreenState.collectAsState().value) {
                    LegalInfoScreen(modelData).Draw()
                    return@Box
                }

                // Draw pages
                val currentPage = modelData.currentPage.collectAsState().value

                when (currentPage) {
                    "FirstStartScreen" -> FirstStartScreen(modelData).draw()
                    "AccessDeniedScreen" -> AccessDeniedScreen(modelData).draw()

                    else -> MainScreen()
                }

                // Overlays

                // Loading screen overlay
                AnimatedVisibility(
                    modelData.isShowLoadingScreenOverlay.collectAsState().value,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    LoadingScreenOverlay(modelData).draw()
                }

                // Help Menu overlay
                AnimatedVisibility(
                    modelData.helpMenuState.collectAsState().value,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    HelpMenu(modelData).Draw()
                }

                // Review Form overlay
                AnimatedVisibility(
                    modelData.reviewDialogState.collectAsState().value != "Closed",
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    ReviewForm(modelData).Draw()
                }
            }

        }
    }


    @Composable
    fun MainScreen() {
        Box (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {

                        // Page
                        val currentPage = modelData.currentPage.collectAsState().value

                        if (currentPage == "Dashboard") {
                            Dashboard(modelData).Draw()
                        }
                        if (currentPage == "Settings") {
                            SettingsPage(modelData).Draw()
                        }
                        if (currentPage == "VoiceChangeGuidelines") {
                            PageWithBottomControls(
                                modelData).Draw(VoiceChangeGuidelines
                                (modelData).content(), false)
                        }

                        if (currentPage == "AllInfo") {
                            PageWithBottomControls(modelData).Draw(
                                AllInfo(modelData).content())
                        }
                        if (currentPage == "SpectrumInfo") {
                            PageWithBottomControls(modelData).Draw(
                                SpectrumInfo(modelData).content())
                        }
                        if (currentPage == "Reading") {
                            Reading(modelData).Draw()
                        }
                        if (currentPage == "Recordings") {
                            Recordings(modelData).Draw()
                        }

                        if (currentPage == "SpeakerVoice") {
                            PageWithBottomControls(modelData).Draw(
                                SpeakerVoice(modelData).content())
                        }

                        if (currentPage == "Singing") {
                            PageWithBottomControls(modelData).Draw(
                                Singing(modelData).content())
                        }

                        if (currentPage == "PitchAndResonance") {
                            PageWithBottomControls(modelData).Draw(
                                PitchAndResonance(modelData).content())
                        }
                        if (currentPage == "VoiceSmoothness") {
                            PageWithBottomControls(modelData).Draw(
                                VoiceSmoothness(modelData).content())
                        }

                        if (currentPage == "FeminineVoice") {
                            PageWithBottomControls(modelData).Draw(
                                FeminineVoice(modelData).content())
                        }
                        if (currentPage == "FeminineVoiceResonance") {
                            PageWithBottomControls(modelData).Draw(
                                FeminineVoiceResonance(modelData).content())
                        }
                        if (currentPage == "MasculineVoice") {
                            PageWithBottomControls(modelData).Draw(
                                MasculineVoice(modelData).content())
                        }
                        if (currentPage == "MasculineVoiceResonance") {
                            PageWithBottomControls(modelData).Draw(
                                MasculineVoiceResonance(modelData).content())
                        }

                        // Main Menu
                        Column(
                            Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                modelData.mainMenuState.collectAsState().value,
                                enter = slideInVertically(initialOffsetY = {it * 2}) + fadeIn(),
                                exit = slideOutVertically(targetOffsetY = {it}) + fadeOut()
                            ) {
                                MainMenu(modelData).Draw()
                            }
                        }
                    }
                }
                // Main Menu Bottom Bar
                MainMenu(modelData).OpenMainMenuButton()
            }

            Popup(modelData).Popup()
            Popup(modelData).PopupWithTextInput()
        }
    }
}
