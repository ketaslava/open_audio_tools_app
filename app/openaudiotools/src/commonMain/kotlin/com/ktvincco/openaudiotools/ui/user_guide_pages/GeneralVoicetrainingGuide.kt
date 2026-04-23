package com.ktvincco.openaudiotools.ui.user_guide_pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.Configuration
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.components.BasicComponents
import com.ktvincco.openaudiotools.ui.charts.Graph
import com.ktvincco.openaudiotools.ui.charts.GraphZone
import com.ktvincco.openaudiotools.ui.components.MultiPageReader
import com.ktvincco.openaudiotools.ui.components.RecordingControl


class GeneralVoicetrainingGuide (modelData: ModelData) : MultiPageReader(modelData) {


    override fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration(
        isAllowBackButtonByState = true
    )


    override fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf(

        // -------------------- Introduction -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Voicetraining Guide",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 28.sp,
                lineHeight = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "In this guide, We're gonna explain to You, how You can do a lot of Cool Stuff with your voice " +
                        "to change it in the way that You want to!" +
                        "\n\n" +
                        "Rn, We're gonna talk about the basics of the voicetraining. " +
                        "In-depth guides for gender affirming voicetraining, and many more, are available separately!" +
                        "\n\n" +
                        "Buckle Up &" +
                        "\n\n" +
                        "Let's GO!",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 18.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(96.dp))
        },
        // -------------------- The Data Explained -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Bragging about The Data",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 28.sp,
                lineHeight = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "So, here is the chart:\n" +
                        "(very real and absolutely adorable)\n",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 18.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Graph().draw(
                data = floatArrayOf(0.0F, 0.33F, 0.1F, 0.5F, 0.75F),
                modelData = modelData,
                yLabelMin = 0F,
                yLabelMax = 1F,
                xLabelMax = 100F,
                isEnableAutoScroll = false,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "RN, it show us something\n\n" +
                        "idk what exactly it shows, but it's definitely changes over time, " +
                        "from 0.0 to 0.75 in a non linear manner\n\n" +
                        "I hope you already understand it, because it is about to get messy, because...\n\n" +
                        "Your voice is pretty & complex! It has a lot of parameters!\n\n" +
                        "...\n\n" +
                        "The most common parameter of the voice is a Pitch. This graph shows it:\n\n" +
                        "(use control buttons to record the sample your voice)",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 18.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Integrated Pitch Graph
            val pitchData = modelData.getGraphData("Pitch")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            Graph().draw(
                data = pitchData,
                modelData = modelData,
                yLabelMin = 50F,
                yLabelMax = 500F,
                xLabelMax = dataDurationSec,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls Integrated
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "As you may see, the graph shows the Pitch of your voice over time\n\n" +
                        "You can scroll and zoom the graph to see the full picture",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 18.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(96.dp))
        },
        // -------------------- The Basics of the Voicetraining -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "The Basics of the Voicetraining",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 28.sp,
                lineHeight = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "So, Now, Let's talk about how we can use the real-time data to reach the " +
                        "goals of improving your the voice! (or whatever your goals are)" +
                        "\n\n...\n\n" +
                        "When humans speak, they are making sounds. " +
                        "Those sounds are not just a random noice, but the handful of patterns. " +
                        "The way that human voice is perceived by other humans, is directly tied to the presence or absence of some special patterns." +
                        "\n\n" +
                        "We can use algorithms to analyze the voice and extract specific characteristics a.k. parameters. " +
                        "There are a lot of parameters that can be extracted, and there are no complete list of them. " +
                        "Some parameters are very simple, they are directly influenced by the physical structure of the human's body, " +
                        "but some are very complex and they describe the patterns of behaviour" +
                        "\n\n" +
                        "Take a time to think about it" +
                        "\n\n" +
                        "..." +
                        "\n\n" +
                        "Let's imagine that we have a goal of changing the perceived gender of the voice fom masculine to feminine" +
                        "\n\n" +
                        "In order to do that, we need to change parameters of the voice that are associated with the gender preception " +
                        "from the masculine range to the feminine range. " +
                        "\n\n" +
                        "The good news are, that in our case, it is completely possible! " +
                        "It is possible for any human being to learn how to speak with different voice parameters. " +
                        "The process of that learning is called the Voicetraining" +
                        "\n\n" +
                        "Keep in mind, that in order to speak in some parameter ranges, it is crucial to have a trained vocal muscles, " +
                        "that are can be trained by practicing speech, but this process takes time... Sometimes a very long long time. " +
                        "Oftentimes, it is physically impossible to reach some ranges without prior voicetraining" +
                        "\n\n" +
                        "K" +
                        "\n\n" +
                        "The Pitch, of which we talked about before, is one of the most common parameters of the voice, " +
                        "and it is directly associated with the gender preception. " +
                        "(But, keep in mind, that if we are gonna change only the pitch, the voice will sound very strange, " +
                        "because the Pitch is not the only parameter that needs to be changed. However, it is the easiest parameter to start with)" +
                        "\n\n" +
                        "The graph below shows the Pitch, " +
                        "",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 18.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            var targetMode by remember { mutableStateOf("Feminine") }

            // Training Selection Buttons
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BasicComponents().Button(
                    modelData,
                    text = "Feminine",
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    targetMode = "Feminine"
                }

                BasicComponents().Button(
                    modelData,
                    text = "Enby",
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    targetMode = "Enby"
                }

                BasicComponents().Button(
                    modelData,
                    text = "Masculine",
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    targetMode = "Masculine"
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Integrated Pitch Graph
            val pitchData = modelData.getGraphData("Pitch")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            val zones = when (targetMode) {
                "Feminine" -> listOf(
                    GraphZone(
                        175F,
                        330F,
                        ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                    )
                )

                "Masculine" -> listOf(
                    GraphZone(
                        85F,
                        155F,
                        ColorPalette.getSoftBlueColor().copy(alpha = 0.25F)
                    )
                )

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

            Spacer(modifier = Modifier.height(96.dp))
        }
    )
}