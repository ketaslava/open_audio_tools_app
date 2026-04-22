package com.ktvincco.openaudiotools.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.Configuration
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.basics.BaseComponents
import com.ktvincco.openaudiotools.ui.charts.Graph
import com.ktvincco.openaudiotools.ui.charts.GraphZone
import com.ktvincco.openaudiotools.ui.components.RecordingControl
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

data class GuideStep(
    val title: String,
    val content: String,
    val specialAction: @Composable (ModelData) -> Unit = {}
)

class UserGuide(
    private val modelData: ModelData
) {

    @Composable
    fun Draw() {
        var currentStepIndex by remember { mutableStateOf(0) }
        val steps = getSteps()
        val currentStep = steps[currentStepIndex]
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorPalette.getBackgroundColor())
        ) {
            // Scrollable Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp)
            ) {
                // Big Header (Vertically Aligned/Centered)
                Column(
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    DynamicText(
                        text = currentStep.title,
                        modelData = modelData,
                        color = ColorPalette.getTextColor(),
                        fontSize = 28.sp,
                        lineHeight = 36.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }

                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp
                )

                DynamicText(
                    text = currentStep.content,
                    modelData = modelData,
                    color = ColorPalette.getTextColor(),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .fillMaxWidth()
                )

                // Integrated special UI (Graph, Buttons, etc)
                currentStep.specialAction(modelData)

                Spacer(modifier = Modifier.height(32.dp))
            }

            // Bottom Navigation Buttons (Big and organized like popups)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(ColorPalette.getBackgroundColor()),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back Button
                if (currentStepIndex > 0) {
                    BigNavButton(text = "BACK", modifier = Modifier.weight(1f)) {
                        currentStepIndex--
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }

                // Page Counter
                DynamicText(
                    text = "${currentStepIndex + 1} / ${steps.size}",
                    modelData = modelData,
                    color = ColorPalette.getTextColor(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Next Button
                if (currentStepIndex < steps.size - 1) {
                    BigNavButton(text = "NEXT", modifier = Modifier.weight(1f)) {
                        currentStepIndex++
                    }
                } else {
                    BigNavButton(text = "FINISH", modifier = Modifier.weight(1f)) {
                        modelData.openPage("Dashboard")
                    }
                }
            }
        }
    }

    @Composable
    private fun BigNavButton(text: String, modifier: Modifier, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = modifier.fillMaxHeight().padding(4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorPalette.getBlockColor(),
                contentColor = ColorPalette.getButtonColor()
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            DynamicText(
                text = text, 
                modelData = modelData, 
                fontSize = 18.sp, 
                fontWeight = FontWeight.ExtraBold
            )
        }
    }

    private fun getSteps(): List<GuideStep> = listOf(
        GuideStep(
            title = "Voice Training\nIntroduction",
            content = "Welcome to your personal voice training guide. This journey is about building muscle memory and learning to perceive your voice as a scientific instrument.\n\n" +
                    "Below you can find the recording controls. Tap 'Start' to begin your first test."
        ),
        GuideStep(
            title = "Mastering\nthe Pitch",
            content = "Pitch is the foundation. Every person has a range where their voice sounds most natural and healthy. We use a 'Green Zone' to represent this target area.\n\n" +
                    "Use the buttons below to switch between training modes. Try to keep your voice line inside the shaded area as you speak or hum.",
            specialAction = { modelData ->
                var targetMode by remember { mutableStateOf("None") }
                
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Training Selection Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { targetMode = "Feminine" },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (targetMode == "Feminine") ColorPalette.getSoftGreenColor() else ColorPalette.getBlockColor()
                            )
                        ) {
                            Text("Feminine", color = ColorPalette.getTextColor())
                        }
                        Button(
                            onClick = { targetMode = "Masculine" },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (targetMode == "Masculine") ColorPalette.getSoftBlueColor() else ColorPalette.getBlockColor()
                            )
                        ) {
                            Text("Masculine", color = ColorPalette.getTextColor())
                        }
                    }

                    // Integrated Pitch Graph
                    val pitchData = modelData.getGraphData("Pitch")
                    val recordingState = modelData.recordingState.collectAsState().value
                    val dataDurationSec = modelData.dataDurationSec.collectAsState().value

                    val zones = when (targetMode) {
                        "Feminine" -> listOf(GraphZone(175F, 330F, ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))
                        "Masculine" -> listOf(GraphZone(85F, 155F, ColorPalette.getSoftBlueColor().copy(alpha = 0.25F)))
                        else -> listOf()
                    }

                    Graph().draw(
                        data = pitchData,
                        modelData = modelData,
                        yLabelMin = 50F,
                        yLabelMax = 500F,
                        graphZones = zones,
                        xLabelMax = dataDurationSec,
                        isEnableAutoScroll = recordingState,
                        autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                        modifier = Modifier.fillMaxWidth().height(250.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Recording Controls Integrated
                    RecordingControl(modelData).Draw()
                }
            }
        ),
        GuideStep(
            title = "Final\nNotes",
            content = "Training takes time. Do not rush. Your throat muscles need rest just like any other muscle in your body.\n\n" +
                    "You can find all these charts and more detailed analysis in the main modes. Look at the arrow below—that is your key to all tools.",
            specialAction = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    Image(
                        painterResource(Res.drawable.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        null,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                    DynamicText(
                        text = "The Main Menu is here",
                        modelData = modelData,
                        color = ColorPalette.getBlockColor(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    )
}
