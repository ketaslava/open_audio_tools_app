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
                "Voicetraining Guide"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "In this guide, We're gonna explain to You, how You can do a lot of Cool Stuff with your voice " +
                        "to change it in the way that You want to!" +
                        "\n\n" +
                        "Rn, We're gonna talk about the basics of the voicetraining. " +
                        "In-depth guides for gender affirming voicetraining, and many more, are available separately!" +
                        "\n\n" +
                        "Buckle Up &" +
                        "\n\n" +
                        "Let's GO!"
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
                "So, here is the chart:\n" +
                        "(very real and absolutely adorable)"
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "RN, it show us something\n\n" +
                        "idk what exactly it shows, but it's definitely changes over time, " +
                        "from 0.0 to 0.75 in a non linear manner\n\n" +
                        "I hope you already understand it, because it is about to get messy, because...\n\n" +
                        "Your voice is pretty & complex! It has a lot of parameters!\n\n" +
                        "...\n\n" +
                        "The most common parameter of the voice is a Pitch. This graph shows it:\n\n" +
                        "(use control buttons to record the sample your voice)"
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recording Controls Integrated
            RecordingControl(modelData).Draw()

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "As you may see, the graph shows the Pitch of your voice over time" +
                        "\n\n" +
                        "You can scroll and zoom the graph to see the full picture" +
                        "\n\n" +
                        "Take a look at the control buttons. Beside obvious \"Record\" and \"Play\" buttons, you can press " +
                        "\"Delete\" to delete the recorded sample, or you can save it, using the \"Save\" button." +
                        "\n\n" +
                        "Saved recordings are stored inside the recordings library. You can access them trough the menu. " +
                        "After saving the recording, feel free to reset the recorder" +
                        "\n\n" +
                        "You can always load saved recordings to see the parameters"
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
                "This is a Spectrogram:"
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
                    .height(256.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "It shows us the energy distribution for each frequency over time" +
                        "\n\n" +
                        "Low frequencies are on the bottom and high frequencies are on the top. " +
                        "The brighter the spot, the higher the energy for the frequency" +
                        "\n\n" +
                        "In this example, one frequency goes from roughly 30 to around 55 and then goes back to 30 again" +
                        "\n\n" +
                        "..." +
                        "\n\n" +
                        "If there are several lines, it means that the sound is made from multiple frequencies at once" +
                        "\n\n" +
                        "The Spectrogram helps us understand complex sounds, such as the human voice" +
                        "\n\n" +
                        "As an example, when we pronounce vowels, the vocal cords are producing harmonic sound, " +
                        "which means that it has a base frequency H0 + multiple harmonics H1, H2, H3, H4, etc. " +
                        "You can see them as lines on the spectrogram" +
                        "\n\n" +
                        "Try to pronounce vowels with different pitch, and also, try syllables. See how it works!"
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Integrated Spectrogram
            val pointerPosition = modelData.pointerPosition.collectAsState().value
            val spectrogramData = modelData.getSpectrogramData("SpectrogramInHz")
            val recordingState = modelData.recordingState.collectAsState().value
            val dataDurationSec = modelData.dataDurationSec.collectAsState().value

            Spectrogram().Spectrogram(
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
                "The Basics of the Voicetraining"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "So, Now, Let's talk about how we can use the real-time data to reach the " +
                        "goals of improving your the voice! (or whatever your goals are)" +
                        "\n\n...\n\n" +
                        "When humans speak, they make sounds. " +
                        "Those sounds are not just a random noice, but the handful of patterns. " +
                        "The way that human voice is perceived by other humans, is directly tied to the presence or absence of some special patterns" +
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
                        "The good news is, that in our case, it is completely possible! " +
                        "It is possible for any human being to learn how to speak with voice parameters that are belong to the range of any desired gender! " +
                        "The process of that learning is called the Voicetraining" +
                        "\n\n" +
                        "Keep in mind, that in order to speak in some ranges, it is crucial to have a trained vocal muscles, " +
                        "that are can be trained by practicing speech, but this process takes time... Sometimes, a very long long time. " +
                        "Oftentimes, it is physically impossible to reach some ranges without prior voicetraining" +
                        "\n\n" +
                        "K" +
                        "\n\n" +
                        "The Pitch, of which we talked about before, is one of the most common parameters of the voice, " +
                        "and it is directly associated with the gender preception. " +
                        "(But keep in mind, that if we're gonna change only the pitch, the voice will sound very strange, " +
                        "because the Pitch is not the only parameter that needs to be changed, however, it is the easiest parameter to start with)" +
                        "\n\n" +
                        "The graph below shows the Pitch" +
                        "\n\n" +
                        "Choose the pitch range for a desired or the most comfortable gender " +
                        "and try to hold the pitch inside the green zone while you pronounce the vowel \"A\""
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
                        350F,
                        ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                    )
                )

                "Enby" -> listOf(
                    GraphZone(
                        140F,
                        185F,
                        ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                    )
                )

                "Masculine" -> listOf(
                    GraphZone(
                        50F,
                        150F,
                        ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                    )
                )

                else -> listOf()
            }

            Graph().draw(
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
                "Here, you may experience some struggles of holding your voice inside the chosen range. " +
                        "That's normal. It means that your muscles are not trained enough to consistently reach the desired range. " +
                        "You need to spent time practicing to train them. " +
                        "Just try to reach the chosen range over and over again and eventually, you will get there" +
                        "\n\n" +
                        "During the voicetraining, it is important to not overexert yourself. Drink water and take breaks! " +
                        "Muscle training can take month" +
                        "\n\n" +
                        "But" +
                        "\n\n" +
                        "It is also completely possible that you're not experiencing any problems of holding your voice inside the chosen range, " +
                        "however, your voice still sound not as you want it to" +
                        "\n\n" +
                        "That means that your muscles are well trained, but you still have problems with your technique, " +
                        "or you may not account some other, very important parameters, " +
                        "like in our case, to change the perceived gender of the voice, " +
                        "the changes in Pitch are not enough, you also need to work on Resonance" +
                        "\n\n" +
                        "Don't worry, the success is absolutely possible!"
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
                "Yaay!" +
                        "\n\n" +
                        "Now you know the basics of the Voicetraining!" +
                        "\n\n" +
                        "Here, We talked only about one example, " +
                        "but the same principle of building muscles and improving technique is " +
                        "can be applied for any voice improvements that you wanna make!" +
                        "\n\n" +
                        "Keep trying smart, and, We believe in You!"
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
                modifier = Modifier
                    .heightIn(min = 64.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                modelData.navigation.setPreviousPage("GeneralVoicetrainingGuide")
                modelData.openPage("GenderAffirmingVoicetrainingGuide")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BasicComponents().Button(
                modelData,
                text = "Finish the Guide >",
                fontSize = 18.sp,
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
