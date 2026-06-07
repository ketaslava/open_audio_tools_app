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
import com.ktvincco.openaudiotools.ui.components.ReaderComponents
import com.ktvincco.openaudiotools.ui.components.RecordingControl


class GenderAffirmingVoicetrainingGuide (modelData: ModelData) : MultiPageReader(modelData) {


    val readerComponents = ReaderComponents(modelData)


    override fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration(
        startPageIndex = 0, // DEV
        isAllowBackButtonByState = true,
        isEnableNextButtonDestinationPage = true,
        nextButtonDestinationPageName = "TheGuideIsFinishedPage"
    )


    override fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf(
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Gender Affirming Voicetraining Guide"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_Centred(
                "Hey Hey Hey!" +
                        "\n\n" +
                        "This is an ultimate guide on how to Feminize / Enbyize / Masculinize your voice " +
                        "through the power of Voicetraining" +
                        "\n\n" +
                        "We're gonna teach you a handful of tips & tricks on how to make your voice " +
                        "sound absolutely astonishing! " +
                        "\n\n" +
                        "We've put our best efforts in making this guide 4 U, and We hope that you'll enjoy it! " +
                        "Ngl, this guide is very complex, it involves a lot of in-depth theory and a lot of routine practice. " +
                        "We wish you high brain power and great patience with the results! " +
                        "Don't forget to drink your water and take breaks as needed! " +
                        "\n\n" +
                        "We believe in You!" +
                        "\n\n" +
                        "btw, If you are not familiar with the Basics of the Voicetraining, " +
                        "We highly recommend you to take a General Voicetraining Guide first. TY!" +
                        "\n\n" +
                        "K..." +
                        "\n\n" +
                        "Let's GO!"
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Basic theory"
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "In this section, we are gonna go over the basics" +
                        "\n\n" +
                        "We're gonna explain to you, how humans are producing their voices and " +
                        "what voice parameters are affecting the gender perception of the voice",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "How does the voice work. The sound formation",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "Sound waves are vibrations of the elastic material (air, water, metal, etc.)" +
                        "\n\n" +
                        "Unlike transverse waves (light photons or ocean waves), " +
                        "the sound waves are not made from particles that are moving from source to receiver. " +
                        "Instead, the altering regions of high and low pressure are propagating through the material. " +
                        "Molecules are oscillating, but staying mostly in place. " +
                        "When the sound waves are hitting our eardrums, they induce vibrations " +
                        "that can be detected by the nervous system and then converted to the perception of the sound." +
                        "\n\n" +
                        "There are many ways to create a sound, but each of them revolves around one core principle of " +
                        "somehow inducing the vibrations into the air. " +
                        "The human voice uses 3 things to do so:\n" +
                        "\n    1. Turbulent airflow " +
                        "\n    2. Surface vibration " +
                        "\n    3. Pressure bursts " +
                        "\n\n" +
                        "The music drum is pushing the air using a membrane when the drumstick hits it. " +
                        "Just like a drum, the vocal chords are transferring the vibrations into the air, " +
                        "but, unlike the drum, they do not have drumsticks, instead, " +
                        "they vibrate because the air is pushed through them. " +
                        "Vibrating vocal chords are producing harmonic sound, which has the base frequency H1 a.k.a. " +
                        "pitch that you can control. " +
                        "\n\n" +
                        "You can not speak without exhaling, because the vocal chords will not vibrate. " +
                        "But, you can always speak without utilizing vocal chords (you still have to exhale). " +
                        "Speaking that way is called whispering. " +
                        "\n\n" +
                        "When you whisper, you're pushing the airflow through your airways. " +
                        "When the air is moving beside the uneven surface, it has a natural tendency to " +
                        "form turbulent vortices, that are producing the white noise " +
                        "(technically it's red, but we're gonna call it white). " +
                        "The white noise is a sound that consists of all frequencies at once. " +
                        "\n\n" +
                        "You can not control what frequencies the white noise initially produces, " +
                        "but somehow you can still differentiate between whispered " +
                        "A, C, E, F, G, H, J, K, L, M, N, O, R, S, U, V. " +
                        "That's because after the white noise was already produced, it gets modified by the resonance. " +
                        "The airways that the sound is going through have resonant frequencies, " +
                        "that are amplifying some parts of the white noise, while the other parts are diminishing. " +
                        "When you're moving your whisper between A, I, O, U, etc, the only thing that is changing " +
                        "is the resonant profile of your vocal tract, a.k.a. you control the resonance. " +
                        "\n\n" +
                        "In this guide, we will use \"w\" before the letter as a marker for the whisper. " +
                        "I.e. wA stand for whispered A. " +
                        "\n\n" +
                        "Voiceless consonants (include all whispered sounds) are can be divided into fricatives and occlusives. " +
                        "Fricatives like F, H, S, wA, wI, wO are can be prolonged during speech, " +
                        "while occlusives like P, T, wB, wD are can not be prolonged. " +
                        "Fricatives are made entirely from turbulent airflow noise modified by the resonance, " +
                        "while occlusives are using pressure bursts to generate subdued pops. " +
                        "\n\n" +
                        "The interesting thing here is that a lot of things that control the resonance " +
                        "(lips, tongue, mouth closure) are also can be used to create occlusions, " +
                        "so it would be incorrect to separate them, instead we will talk about them " +
                        "as a broader category called the Shape of a Vocal Tract a.k.a. the Shape. " +
                        "(Technically, the vocal chords are parts of a vocal tract, " +
                        "so they're the shape too, but we're gonna separate them due to their complexity)" +
                        "\n\n" +
                        "Thus, from the user's perspective, the human voice is made from " +
                        "3 main components that you can control independently:\n" +
                        "\n    * Airflow " +
                        "\n    * Shape " +
                        "\n    * Vocal Chords " +
                        "\n\n" +
                        "(In this guide, we're gonna call the Sound produced by the Vocal Chords by the name " +
                        "of its primary parameter \"Pitch\")" +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "A lot of sources may tell you that all sounds are inherently divided into " +
                        "vowels, voiced consonants, and voiceless consonants. " +
                        "But this system is actually very very arbitrary, so don't focus on being precise with it. " +
                        "\n\n" +
                        "Anyway, here is the *approximate* table for the normal speech: " +
                        "\n" +
                        "\nVowel <= Pitch * Resonance " +
                        "\nVoiced Consonant <= (Pitch + Noise) * Resonance " +
                        "\nVoiceless Consonant <= Noise * Resonance " +
                        "\n\n" +
                        "And remember that everything becomes a voiceless consonant during whispering. " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Important Factors for achieving the Correct Gender Preception",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "Here is the list of distinct parameters that affect the gender and general perception of the voice:\n" +
                        "\n    * Resonance" +
                        "\n    * Pitch" +
                        "\n    * Subtone" +
                        "\n    * Prosody" +
                        "\n    * Vocal Weight" +
                        "\n    * Twang" +
                        "\n    * False Vocal Chords" +
                        "\n    * Front muscles and speaking patterns" +
                        "\n\n" +
                        "Voice parameters that affect the gender perception the most are " +
                        "Resonance and Vocal Weight. They are the foundation " +
                        "\n\n" +
                        "Pitch is also an important parameter, but not as important as previous two " +
                        "\n\n" +
                        "False Vocal Chords and Twang are not directly affecting the gender perception, " +
                        "but we still need to focus on them in order to achieve the natural sounding " +
                        "\n\n" +
                        "Subtone and Prosody are not really affecting the voice perception, " +
                        "but we're gonna talk about them to fully understand the voice " +
                        "\n\n" +
                        "Front muscles and speaking patterns are really sus. " +
                        "We're gonna explain them to you ",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Tactics and Misconceptions",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "Here is some important things that you need to know before we gonna start the voicetraining:" +
                        "\n\n" +
                        "1. Pitch is not the most important thing to achieve a " +
                        "desired voice perception; Resonance and Vocal Weight are " +
                        "\n\n" +
                        "2. Do not think in ambiguous terminology like the \"Head Voice\" / \"Chest Voice\". " +
                        "For this tutorial, no magical voice movements is permitted! " +
                        "\n\n" +
                        "3. Most of the time, it is physically impossible for an unvoicetrained individual " +
                        "to achieve the desired gender of the voice immediately. " +
                        "Even if you understand everything and gain the right technique instantly, " +
                        "you will still need time to build necessary muscles. To do that, " +
                        "you need to spend time practicing, which can take around a month or several " +
                        "\n\n" +
                        "4. Do not overexert yourself. Excessive voicetraining through pain might lead " +
                        "to physical complications which we don't want" +
                        "\n\n" +
                        "5. The \"Natural Voice\" concept is a myth. Even tough there are some limits on " +
                        "what parameter ranges are available for each person, the default voice of an individual " +
                        "is not based on them. The default voice, like an accent, is acquired during the lifelong " +
                        "development process and can be fully and permanently overwritten through practice. " +
                        "\n\n" +
                        "6. There are two primary ways of developing a voice technique, " +
                        "and they often conflict with each other. " +
                        "Mimicry i.e. relying on feel to close the gap between current and desired sounding VS " +
                        "Conscious control of the muscles to correct the gap manually. " +
                        "We insist that raw mimicry can never achieve results >= 100% even in the best case. " +
                        "The conscious understanding and control is crucial for everyone, " +
                        "especially for those who may struggle with " +
                        "auditory processing / neurodivergence / dyslexia. " +
                        "The mimicry is can be very good and useful as a tool, but it should never be the only option ",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Let's Voicetrain",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "That was the theory..." +
                        "\n\n" +
                        "Now, let's do the practice! " +
                        "\n\n" +
                        "We're gonna go over each parameter and exercise our basic human right to uncanny speech! " +
                        "\n\n" +
                        "During the exercises, you may feel emotions like awkwardness, cringe, " +
                        "and hysterical possession. Embrace them. " +
                        "\n\n" +
                        "For this time, we're gonna assume that our goal is to " +
                        "change the perceived gender of the voice to feminine. " +
                        "If it is not the case for you, just pursue the different target values" +
                        "\n\n" +
                        "Good patience!",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Resonance",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
    )
}