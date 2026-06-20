package com.ktvincco.openaudiotools.ui.user_guide_pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.Configuration
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.components.BasicComponents
import com.ktvincco.openaudiotools.ui.charts.Graph
import com.ktvincco.openaudiotools.ui.charts.GraphZone
import com.ktvincco.openaudiotools.ui.charts.Spectrogram
import com.ktvincco.openaudiotools.ui.components.MultiPageReader
import com.ktvincco.openaudiotools.ui.components.ReaderComponents
import com.ktvincco.openaudiotools.ui.components.RecordingControl


class GeneralVoicetrainingGuide (modelData: ModelData) : MultiPageReader(modelData) {


    val readerComponents = ReaderComponents(modelData)


    override fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration(
        isAllowBackButtonByState = true
    )


    override fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf(

        // -------------------- Introduction -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "The Voicetraining Guide "
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "In this guide, We're gonna explain to You, how You can do a lot of " +
                        "Cool Stuff with your voice to change it in the way that You want! " +
                        "\n\n" +
                        "Rn, We're gonna talk about the basics of a voicetraining. " +
                        "In-depth guide for a gender affirming voicetraining, " +
                        "and many more, are available separately! " +
                        "\n\n" +
                        "Buckle Up &" +
                        "\n\n" +
                        "Let's GO "
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        // -------------------- The Data Explained -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Bragging about The Data"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "So, here is the chart: \n" +
                        "(very real and absolutely adorable) "
            )

            Spacer(modifier = Modifier.height(32.dp))

            Graph().Draw(
                data = floatArrayOf(0.0F, 0.33F, 0.1F, 0.5F, 0.75F),
                modelData = modelData,
                yLabelMin = 0F,
                yLabelMax = 1F,
                xLabelMax = 100F,
                isEnableAutoScroll = false,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "RN, it is showing us something " +
                        "\n\n" +
                        "idk what exactly it shows, but it is definitely changes over time, " +
                        "from 0.0 to 0.75 in a non linear manner " +
                        "\n\n" +
                        "I hope that you're already understand it, because it is about to get messy, because... " +
                        "\n\n" +
                        "Your voice is pretty & complex! It has a lot of parameters! " +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "The most common parameter of a voice is a Pitch. This graph shows it: " +
                        "\n\n" +
                        "(use control buttons to record a sample of your voice) "
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Integrated Pitch Graph
            val pitchData = modelData.getGraphData("Pitch")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            Graph().Draw(
                data = pitchData,
                modelData = modelData,
                yLabelMin = 50F,
                yLabelMax = 500F,
                xLabelMax = dataDurationSec,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls Integrated
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "As you may see, the graph shows the Pitch of your voice over time " +
                        "\n\n" +
                        "You can scroll and zoom the graph to see a full picture " +
                        "\n\n" +
                        "Take a look at the control buttons. Beside obvious \"Record\" and \"Play\" buttons, you can press " +
                        "the \"Delete\" button to delete the recorded sample, or you can save it, using the \"Save\" button " +
                        "\n\n" +
                        "Saved recordings are stored inside a recordings library. You can access them through the menu. " +
                        "After saving the recording, feel free to reset the recorder " +
                        "\n\n" +
                        "You can always load saved recordings to see the parameters again "
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        // -------------------- The Spectrogram Explained -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "The Spectrogram Explained"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "This is a Spectrogram: " +
                        "\n\n"
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
            )

            Spectrogram().Draw(
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
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "\n\n" +
                        "It shows us the energy distribution for each frequency over time " +
                        "\n\n" +
                        "Low frequencies are on the bottom and high frequencies are on the top. " +
                        "The brighter the spot, the higher the energy for the frequency " +
                        "\n\n" +
                        "In this example, the spectrogram shows us how the main frequency of " +
                        "the sound changes from roughly 30 to around 55 " +
                        "and then it goes back to 30 again, all in a span of a 100 " +
                        "\n\n" +
                        "..." +
                        "\n\n" +
                        "If the spectrogram has several lines, it means that the sound is " +
                        "made from multiple frequencies at once " +
                        "\n\n" +
                        "A Spectrogram helps us understand complex sounds, such as a human voice " +
                        "\n\n" +
                        "As an example, when we pronounce vowels, the vocal cords are producing a harmonic sound, " +
                        "which has a base frequency H1 + multiple harmonics H2, H3, H4, H5, etc. " +
                        "You can see them as lines on the spectrogram " +
                        "\n\n" +
                        "Try to pronounce vowels with a different pitch, and also, try syllables. See how it works! "
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Integrated Spectrogram
            val pointerPosition = modelData.pointerPosition.collectAsState().value
            val spectrogramData = modelData.getSpectrogramData("SpectrogramInHz")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            Spectrogram().Draw(
                data = spectrogramData,
                modelData = modelData,
                multiplyValue = 24F,
                xLabelMin = 0F,
                xLabelMax = dataDurationSec,
                yLabelMin = 0F,
                yLabelMax = 4096F,
                horizontalLinesCount = 8,
                pointerPosition = pointerPosition,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(384.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(128.dp))
        },
        // -------------------- The Basics of the Voicetraining -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "The Basics of Voicetraining"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "So now, Let's talk about how we can use real-time data to reach the " +
                        "goals of improving your voice! (or whatever goals you have) " +
                        "\n\n" +
                        "..." +
                        "\n\n" +
                        "When humans speak, they make sounds. " +
                        "This sound is not just a random noise, but the handful of patterns. " +
                        "The way that a human voice is perceived by humans, is directly tied to " +
                        "the presence or absence of some special patterns " +
                        "\n\n" +
                        "We can use algorithms to analyze a voice and extract specific characteristics a.k.a. parameters. " +
                        "There are a lot of parameters that can be extracted, and there is no complete list of them. " +
                        "Some parameters are very simple, they are directly influenced by the physical structure of a human body, " +
                        "but some are very complex and they describe complex behaviours " +
                        "\n\n" +
                        "Take the time to think about it " +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "Let's imagine that we have a goal of changing the perceived gender of a voice from masculine to feminine " +
                        "\n\n" +
                        "In order to do that, we need to change parameters of the voice that are associated with a gender perception " +
                        "from a masculine range to a feminine range " +
                        "\n\n" +
                        "The good news is, that in our case, it is completely possible! " +
                        "It is possible for any human being to learn how to speak with voice parameters " +
                        "that are belong to the range of any desired gender! " +
                        "The process of that learning is called Voicetraining " +
                        "\n\n" +
                        "Keep in mind that in order to speak in some ranges, it is crucial to have " +
                        "the trained vocal muscles, which can be trained by practicing speech. " +
                        "This process takes time... Sometimes, the very long long time. " +
                        "Oftentimes, it is physically impossible to reach some ranges without prior voicetraining " +
                        "\n\n" +
                        "K" +
                        "\n\n" +
                        "The Pitch is one of the most common parameters of a voice, " +
                        "and it is directly associated with a gender preception. " +
                        "(Keep in mind, that if we're gonna change only the pitch, the voice will sound very strange, " +
                        "because the Pitch is not the only parameter that needs to be changed, " +
                        "it is just the easiest parameter to use as an example) " +
                        "\n\n" +
                        "The graph below shows the Pitch" +
                        "\n\n" +
                        "Choose the pitch range for the desired or the most comfortable gender. " +
                        "Try holding the pitch inside the green zone while you pronounce a vowel \"A\""
            )

            Spacer(modifier = Modifier.height(32.dp))

            var targetMode by remember { mutableStateOf("Feminine") }

            // Training Selection Buttons
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BasicComponents().Button(modelData, text = "Feminine",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                    targetMode = "Feminine" }

                BasicComponents().Button(modelData, text = "Enby",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                    targetMode = "Enby" }

                BasicComponents().Button(modelData, text = "Masculine",
                    modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                    targetMode = "Masculine" }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Integrated Pitch Graph
            val pitchData = modelData.getGraphData("Pitch")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            val zones = when (targetMode) {
                "Feminine" -> listOf(GraphZone(175F, 350F,
                    ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

                "Enby" -> listOf(GraphZone(140F, 185F,
                    ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

                "Masculine" -> listOf(GraphZone(50F, 150F,
                        ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

                else -> listOf()
            }

            Graph().Draw(
                data = pitchData,
                modelData = modelData,
                yLabelMin = 0F,
                yLabelMax = 512F,
                graphZones = zones,
                xLabelMax = dataDurationSec,
                isEnableAutoScroll = recordingState,
                autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(384.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls Integrated
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "Here, you may experience some struggles in holding your voice inside the chosen range. " +
                        "It is normal. It means that your muscles are not trained enough to consistently reach the desired range. " +
                        "You need to spend time practicing to train them. " +
                        "Just try to reach the chosen range over and over again and eventually, you'll be there " +
                        "\n\n" +
                        "During a voicetraining, it is important to not overexert yourself. " +
                        "Drink water and take breaks! Muscle Training can take months " +
                        "\n\n" +
                        "But" +
                        "\n\n" +
                        "It is also completely possible that you're not experiencing any problems of " +
                        "holding your voice inside the chosen range, " +
                        "however, your voice still sound not as you expect " +
                        "\n\n" +
                        "That means that your pitch muscles are already well trained, " +
                        "but you still have problems with other very important parameters, " +
                        "like in our case, to change the perceived gender of a voice, " +
                        "the changes in Pitch are not enough, you also need to work on Resonance " +
                        "\n\n" +
                        "Don't worry, the success is absolutely possible! "
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        // -------------------- Conclusion -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Conclusion"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "" +
                        "Yaay!" +
                        "\n\n" +
                        "Now you know the basics of Voicetraining!" +
                        "\n\n" +
                        "Here we talked only about one example, " +
                        "but the same principle of building muscles and improving a technique " +
                        "can be applied for any voice improvements that you desire! " +
                        "\n\n" +
                        "Keep working smart, and, We Believe In You! "
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        // -------------------- What's next? -------------------- //
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "What's next?"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "Choose the option"
            )

            Spacer(modifier = Modifier.height(32.dp))

            BasicComponents().Button(
                modelData,
                text = "Gender Affirming Voicetraining >",
                fontSize = 18.sp,
                buttonColor = Color.hsl(0F, 0F, 0.25F),
                modifier = Modifier
                    .heightIn(min = 64.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                modelData.navigation.setPreviousPage("GeneralVoicetrainingGuide",
                    modelData.currentInReaderPageIndex.value)
                modelData.openPage("GenderAffirmingVoicetrainingGuide")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BasicComponents().Button(
                modelData,
                text = "Finish the Guide >",
                fontSize = 18.sp,
                buttonColor = Color.hsl(0F, 0F, 0.25F),
                modifier = Modifier
                    .heightIn(min = 64.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                modelData.openPage("TheGuideIsFinishedPage")
            }

            Spacer(modifier = Modifier.height(128.dp))
        }
    )
}
