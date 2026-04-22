package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.ui.basics.BaseComponents
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.PageRegistry
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.menu_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

class MainMenu (private val modelData: ModelData) {


    @Composable
    fun OpenMainMenuButton() {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(ColorPalette.getBlockColor())
                .clickable { modelData.switchMainMenuState() }
                .padding(horizontal = 32.dp)
        ) {
            val currentPageId = modelData.currentPage.collectAsState().value
            val text = PageRegistry.getDisplayName(currentPageId)

            DynamicText(
                text = text,
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            Image(
                painterResource(Res.drawable.menu_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
        }
    }


    @Composable
    fun Draw() {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(state = ScrollState(0))
                .background(ColorPalette.getBlockColor()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            DynamicText(
                text = "Main Menu",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 24.sp,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 20.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(state = ScrollState(0)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("Dashboard") {
                    modelData.openPage("Dashboard")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Settings") {
                    modelData.openPage("Settings")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Voice Change Guidelines") {
                    modelData.openPage("VoiceChangeGuidelines")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("All Info") {
                    modelData.openPage("AllInfo")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Spectrum") {
                    modelData.openPage("SpectrumInfo")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Reading") {
                    modelData.openPage("Reading")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Recordings") {
                    modelData.openPage("Recordings")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("Speaker Voice") {
                    modelData.openPage("SpeakerVoice")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("Singing") {
                    modelData.openPage("Singing")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("Pitch And Resonance") {
                    modelData.openPage("PitchAndResonance")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Voice Smoothness") {
                    modelData.openPage("VoiceSmoothness")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("Feminine Voice") {
                    modelData.openPage("FeminineVoice")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Feminine Voice Resonance") {
                    modelData.openPage("FeminineVoiceResonance")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Masculine Voice") {
                    modelData.openPage("MasculineVoice")
                    modelData.setMainMenuState(false)
                }

                MenuItem("Masculine Voice Resonance") {
                    modelData.openPage("MasculineVoiceResonance")
                    modelData.setMainMenuState(false)
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp)

                MenuItem("User Guide") {
                    modelData.openPage("UserGuide")
                    modelData.setMainMenuState(false)
                }

                MenuItem("FAQs") {
                    modelData.openPage("FrequentlyAskedQuestions")
                    modelData.setMainMenuState(false)
                }
            }
        }
    }

    @Composable
    fun MenuItem(text: String, callback: () -> Unit) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { callback.invoke() }
                .padding(16.dp)
        ) {
            DynamicText(
                text = text,
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                style = MaterialTheme.typography.body1
            )
        }
    }

}