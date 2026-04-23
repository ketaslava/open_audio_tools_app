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
import com.ktvincco.openaudiotools.ui.charts.Spectrogram
import com.ktvincco.openaudiotools.ui.components.MultiPageReader
import com.ktvincco.openaudiotools.ui.components.RecordingControl
import com.ktvincco.openaudiotools.ui.components.graphNameText


class SoundAnalysisGuide (modelData: ModelData) : MultiPageReader(modelData) {


    override fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration(
        isAllowBackButtonByState = true,
        isEnableNextButtonDestinationPage = true,
        nextButtonDestinationPageName = "TheGuideIsFinishedPage",
    )


    override fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf(

        // -------------------- Introduction -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Sound Analysis Guide",
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
                text = "In this guide, We're gonna explain to you, how to analyze the sounds using our app" +
                        "\n\n" +
                        "This is a general guide on how our app works. Nothing special. " +
                        "We have other guides for specific use cases, such as voicetraining" +
                        "\n\n" +
                        "Whatever..." +
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
        // -------------------- Bragging about the Data -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Bragging about the Data",
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
                text = "There are several types of data charts in our app" +
                        "\n\n" +
                        "Here, we have a classic line chart:\n" +
                        "(very real and absolutely adorable)",
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
                text = "RN, it show us something" +
                        "\n\n" +
                        "idk what exactly it shows, but it's definitely changes over time, " +
                        "from 0.0 to 0.75 in a non linear manner" +
                        "\n\n" +
                        "..." +
                        "\n\n" +
                        "This is a Spectrogram:",
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

            val demoSpectrogramData = arrayOf(
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
                floatArrayOf(0.0F, 0.025F, 0.1F, 0.3F, 0.8F, 0.3F, 0.1F, 0.025F, 0.0F, 0.0F, 0.0F, 0.0F),
            )

            Spectrogram().Spectrogram(
                data = demoSpectrogramData,
                modelData = modelData,
                xLabelMin = 0F,
                xLabelMax = 100F,
                yLabelMin = 0F,
                yLabelMax = 100F,
                horizontalLinesCount = 8,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "It shows us the energy distribution for each frequency over time",
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
        // -------------------- Recording live data -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Recording live data",
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
                text = "Our app can analyze parameters of the voice in real time\n\n" +
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
            val pointerPosition = modelData.pointerPosition.collectAsState().value
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value
            val loudnessData = modelData.getGraphData("Loudness")
            val pitchData = modelData.getGraphData("Pitch")

            graphNameText(modelData, "Loudness")
            Graph().draw(
                data = loudnessData,
                modelData = modelData,
                pointerPosition = pointerPosition,
                xLabelMax = dataDurationSec,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            graphNameText(modelData, "Pitch")
            Graph().draw(
                data = pitchData,
                modelData = modelData,
                yLabelMin = 50F,
                yLabelMax = 500F,
                xLabelMax = dataDurationSec,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                pointerPosition = pointerPosition,
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls Integrated
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(32.dp))

            DynamicText(
                text = "As you may see, the graph shows the Loudness and the Pitch of your voice over time" +
                        "\n\n" +
                        "You can scroll and zoom the graph to see the full picture" +
                        "\n\n" +
                        "Take a look at the control buttons. Beside obvious \"Record\" and \"Play\" buttons, you can press " +
                        "\"Delete\" to delete the recorded sample, or you can save it, using the \"Save\" button." +
                        "\n\n" +
                        "Saved recordings are stored inside the recordings library. You can access them trough the menu. " +
                        "After saving the recording, feel free to reset the recorder" +
                        "\n\n" +
                        "You can always load saved recordings to see the parameters",
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
        // -------------------- Outroduction -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            DynamicText(
                text = "Outroduction",
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
                text = "Yaay!" +
                        "\n\n" +
                        "Congratulations!" +
                        "\n\n" +
                        "Now you know how to use our app!" +
                        "\n\n" +
                        "Happy UX !!!",
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
    )
}