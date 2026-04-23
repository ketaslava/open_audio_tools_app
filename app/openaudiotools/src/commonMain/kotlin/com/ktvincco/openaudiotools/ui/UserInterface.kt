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
import com.ktvincco.openaudiotools.ui.components.Popup
import com.ktvincco.openaudiotools.ui.screens.AccessDeniedScreen
import com.ktvincco.openaudiotools.ui.screens.FirstStartScreen
import com.ktvincco.openaudiotools.ui.screens.LegalInfoScreen
import com.ktvincco.openaudiotools.ui.screens.LoadingScreenOverlay
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.components.HelpMenu
import com.ktvincco.openaudiotools.ui.components.MainMenu
import com.ktvincco.openaudiotools.ui.components.ReviewForm


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
                        PageRegistry.DrawPage(currentPage, modelData)

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
