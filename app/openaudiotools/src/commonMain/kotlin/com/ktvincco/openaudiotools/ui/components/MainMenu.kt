package com.ktvincco.openaudiotools.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.ui.components.BasicComponents
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.PageRegistry
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import openaudiotools.app.openaudiotools.generated.resources.arrow_forward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
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
            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "Main Menu",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 24.sp,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                NavigationButtons()
            }
        }
    }


    @Composable
    fun NavigationButtons() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .verticalScroll(state = ScrollState(0)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BasicComponents().Button(modelData, text = "Dashboard",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f),
                    buttonColor = Color.hsl(120F, 0.5F, 0.5F)) {
                    modelData.openPage("Dashboard")
                    modelData.setMainMenuState(false)
                }

                BasicComponents().Button(modelData, text = "Settings",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f),
                    buttonColor = Color.hsl(240F, 0.5F, 0.5F)) {
                    modelData.openPage("Settings")
                    modelData.setMainMenuState(false)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BasicComponents().Button(modelData, text = "Reading",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f),
                    buttonColor = Color.hsl(30F, 0.66F, 0.5F)) {
                    modelData.openPage("Reading")
                    modelData.setMainMenuState(false)
                }

                BasicComponents().Button(modelData, text = "Recordings",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f),
                    buttonColor = Color.hsl(0F, 0.66F, 0.5F)) {
                    modelData.openPage("Recordings")
                    modelData.setMainMenuState(false)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            BasicComponents().Button(modelData, text = "All Info",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                modelData.openPage("AllInfo")
                modelData.setMainMenuState(false)
            }

            Spacer(modifier = Modifier.height(16.dp))

            BasicComponents().Button(modelData, text = "Spectrum",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                modelData.openPage("SpectrumInfo")
                modelData.setMainMenuState(false)
            }

            Spacer(modifier = Modifier.height(32.dp))

            BasicComponents().HorizontalDivider(
                color = ColorPalette.getMarkupColor(), thickness = 1.dp)

            ExpandableCategory("Voice Analysis") {

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Singing",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("Singing")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Pitch And Resonance",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("PitchAndResonance")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Speaker Voice",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("SpeakerVoice")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Voice Smoothness",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("VoiceSmoothness")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            BasicComponents().HorizontalDivider(
                color = ColorPalette.getMarkupColor(), thickness = 1.dp)

            ExpandableCategory("Voice Gender Analysis") {

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Feminine Voice",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("FeminineVoice")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Feminine Voice Resonance",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("FeminineVoiceResonance")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Masculine Voice",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("MasculineVoice")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Masculine Voice Resonance",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("MasculineVoiceResonance")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            BasicComponents().HorizontalDivider(
                color = ColorPalette.getMarkupColor(), thickness = 1.dp)

            ExpandableCategory("Real Guides") {

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "==> User Guide <==",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("UserGuide")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Sound Analysis Guide",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("SoundAnalysisGuide")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "General Voicetraining Guide",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("GeneralVoicetrainingGuide")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "Gender Affirming Voicetraining Guide",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("GenderAffirmingVoicetrainingGuide")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(16.dp))
                BasicComponents().Button(modelData, text = "FAQs",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                    buttonColor = Color.hsl(0F, 0F, 0.33F)) {
                    modelData.openPage("FrequentlyAskedQuestions")
                    modelData.setMainMenuState(false)
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            BasicComponents().HorizontalDivider(
                color = ColorPalette.getMarkupColor(), thickness = 1.dp)
        }
    }


    @Composable
    fun ExpandableCategory(title: String, content: @Composable ColumnScope.() -> Unit) {
        var isExpanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 64.dp)
                    .clickable { isExpanded = !isExpanded }
                    .padding(horizontal = 24.dp)
            ) {
                DynamicText(
                    text = title,
                    modelData = modelData,
                    color = ColorPalette.getTextColor(),
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(16.dp))

                val arrowIcon = if (isExpanded) Res.drawable.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
                else Res.drawable.arrow_forward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

                Image(
                    painterResource(arrowIcon),
                    null,
                    modifier = Modifier.width(24.dp).height(24.dp)
                )
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    content()
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
            )
        }
    }

}