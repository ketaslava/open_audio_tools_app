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
import androidx.compose.ui.unit.dp
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
import com.ktvincco.openaudiotools.ui.components.graphNameText


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
                "" +
                        "Hey Hey Hey! " +
                        "\n\n" +
                        "This is an ultimate guide on how to Feminize / Enbyize / Masculinize your voice " +
                        "through the power of Voicetraining " +
                        "\n\n" +
                        "We're gonna teach you a handful of tips & tricks on how to make your voice " +
                        "sound absolutely astonishing! " +
                        "\n\n" +
                        "We've put our best efforts into making this guide 4 U, and We hope that you'll enjoy it! " +
                        "Ngl, this guide is very complex, it involves a lot of in-depth theory and a lot of routine practice. " +
                        "We wish you high brain power and great patience with the results! " +
                        "Don't forget to drink your water and take breaks as needed! " +
                        "\n\n" +
                        "We believe in You! " +
                        "\n\n" +
                        "btw, if you're not familiar with the Basics of Voicetraining, " +
                        "We highly recommend you to take a General Voicetraining Guide first. TY! " +
                        "\n\n" +
                        "K... " +
                        "\n\n" +
                        "Let's GO! "
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
                "" +
                        "In this section, we're gonna go over the basics " +
                        "\n\n" +
                        "We're gonna explain to you, how humans are producing their voices and " +
                        "what voice parameters are affecting gender perception of the voice ",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "How does a voice work. The sound formation",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Sound waves are vibrations of elastic material (air, water, metal, etc.) " +
                        "\n\n" +
                        "Unlike transverse waves (light photons or ocean waves), " +
                        "the sound waves are not made from particles that are moving from source to receiver. " +
                        "Instead, altering regions of high and low pressure are propagating through the material. " +
                        "Molecules are oscillating, but staying mostly in place. " +
                        "When the sound waves are hitting our eardrums, they induce vibrations " +
                        "that can be detected by a nervous system and then converted to perception of the sound " +
                        "\n\n" +
                        "There are many ways to create sound, but each of them revolves around one core principle of " +
                        "somehow inducing vibrations into the air. " +
                        "Human voice uses 3 things to do so: \n" +
                        "\n    1. Turbulent airflow " +
                        "\n    2. Surface vibration " +
                        "\n    3. Pressure bursts " +
                        "\n\n" +
                        "The music drum is pushing air using a membrane when the drumstick hits it. " +
                        "Just like a drum, the vocal chords are transferring the vibrations into the air, " +
                        "but, unlike the drum, they do not have drumsticks, instead, " +
                        "they vibrate because air is pushed through them. " +
                        "Vibrating vocal chords are producing a harmonic sound, which has the base frequency H1 a.k.a. " +
                        "pitch that you can control " +
                        "\n\n" +
                        "You can not speak without exhaling, because the vocal chords will not vibrate. " +
                        "But, you can always speak without utilizing the vocal chords (you still have to exhale). " +
                        "Speaking that way is called whispering " +
                        "\n\n" +
                        "When you whisper, you're pushing the air through your airways. " +
                        "When air is moving beside the uneven surface, it has a natural tendency to " +
                        "form turbulent vortices, that are producing the white noise" +
                        "(technically it's red, but we're gonna call it white). " +
                        "The white noise is a sound that consists of all frequencies at once " +
                        "\n\n" +
                        "You can not control what frequencies the white noise initially produces, " +
                        "but somehow you can still differentiate between whispered " +
                        "A, C, E, F, G, H, J, K, L, M, N, O, R, S, U, V. " +
                        "That's because after the white noise was already produced, it gets modified by resonance. " +
                        "The airways that the sound is going through have resonant frequencies, " +
                        "that are amplifying some parts of the white noise, while the other parts are diminishing. " +
                        "When you're moving your whisper between A, I, O, U, etc, the only thing that is changing " +
                        "is the resonant profile of your vocal tract, a.k.a. you control the resonance " +
                        "\n\n" +
                        "In this guide, we will use \"w\" before the letter as a marker for a whisper. " +
                        "I.e. wA stands for whispered A " +
                        "\n\n" +
                        "Voiceless consonants (include all whispered sounds) can be divided into fricatives and occlusives. " +
                        "Fricatives like F, H, S, wA, wI, wO can be prolonged during speech, " +
                        "while occlusives like P, T, wB, wD can not be prolonged. " +
                        "Fricatives are made entirely from turbulent airflow noise modified by resonance, " +
                        "while occlusives are using pressure bursts to generate subdued pops " +
                        "\n\n" +
                        "The interesting thing here is that a lot of things that control resonance " +
                        "(lips, tongue, mouth closure) can also be used to create occlusions, " +
                        "so it would be incorrect to separate them, instead we will talk about them " +
                        "as a broader category called Shape of a Vocal Tract a.k.a. the Shape. " +
                        "(Technically, vocal chords are parts of a vocal tract, " +
                        "so they're the shape too, but we're gonna separate them due to their complexity) " +
                        "\n\n" +
                        "Thus, from the user's perspective, human voice is made from " +
                        "3 main components that you can control independently:\n" +
                        "\n    * Airflow " +
                        "\n    * Shape " +
                        "\n    * Vocal Chords " +
                        "\n\n" +
                        "(In this guide, we're gonna call the Sound produced by Vocal Chords by the name " +
                        "of its primary parameter \"Pitch\")" +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "A lot of sources may tell you that all sounds are inherently divided into " +
                        "vowels, voiced consonants, and voiceless consonants. " +
                        "But this system is actually very very arbitrary, so don't focus on being precise with it " +
                        "\n\n" +
                        "Anyway, here is the *approximate* table for a normal speech: " +
                        "\n" +
                        "\nVowel <= Pitch * Resonance " +
                        "\nVoiced Consonant <= (Pitch + Noise) * Resonance " +
                        "\nVoiceless Consonant <= Noise * Resonance " +
                        "\n\n" +
                        "And remember that everything becomes a voiceless consonant during whispering " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Important Factors for achieving the Correct Gender Perception",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Here is the list of distinct parameters that affect gender and general perception of a voice:\n" +
                        "\n    * Resonance" +
                        "\n    * Pitch" +
                        "\n    * Subtone" +
                        "\n    * Prosody" +
                        "\n    * Vocal Weight" +
                        "\n    * Twang" +
                        "\n    * False Vocal Chords" +
                        "\n    * Front muscles and speaking patterns" +
                        "\n\n" +
                        "Voice parameters that affect gender perception the most are " +
                        "Resonance and Vocal Weight. They are the foundation " +
                        "\n\n" +
                        "Pitch is also an important parameter, but not as important as previous two " +
                        "\n\n" +
                        "False Vocal Chords and Twang are not directly affecting gender perception, " +
                        "but we still need to focus on them in order to achieve a natural sounding " +
                        "\n\n" +
                        "Subtone and Prosody are not really affecting voice perception, " +
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
                "" +
                        "Here are some important things that you need to know before we gonna start the voicetraining:" +
                        "\n\n" +
                        "1. Pitch is not the most important thing for achieving " +
                        "the desired gender perception of a voice; Resonance and Vocal Weight are " +
                        "\n\n" +
                        "2. Do not think in ambiguous terminology like the \"Head Voice\" / \"Chest Voice\". " +
                        "For this tutorial, no magical voice movements are permitted! " +
                        "\n\n" +
                        "3. Most of the time, it is physically impossible for an unvoicetrained individual " +
                        "to achieve the desired gender of the voice immediately. " +
                        "Even if you understand everything and gain the right technique instantly, " +
                        "you will still need time to build necessary muscles. To do that, " +
                        "you need to spend time practicing, which can take around a month or several " +
                        "\n\n" +
                        "4. Do not overexert yourself. Excessive voicetraining through pain might lead " +
                        "to unwanted physical complications " +
                        "\n\n" +
                        "5. The \"Natural Voice\" concept is a myth. Even though there are some limits on " +
                        "what parameter ranges are available for each person, the default voice of an individual " +
                        "is not based on them. The default voice, like an accent, is acquired during a lifelong " +
                        "development process and can be fully and permanently overwritten through practice. " +
                        "\n\n" +
                        "6. There are two primary ways of developing a voice technique, " +
                        "and they often \"conflict\" with each other. " +
                        "Mimicry i.e. relying on feel to close the gap between current and desired sounding VS " +
                        "Conscious control of muscles to correct the gap manually. " +
                        "We insist that raw mimicry can never achieve results >= 100% even in the best case scenario. " +
                        "The conscious understanding and control are crucial for everyone, " +
                        "especially for those who may struggle with " +
                        "auditory processing / neurodivergence / dyslexia. " +
                        "The mimicry can be very good and useful as a tool, but it should never be the only option ",
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
                "" +
                        "That was the theory..." +
                        "\n\n" +
                        "So, now, let's do the practice! " +
                        "\n\n" +
                        "For this time, we're gonna assume that our goal is to " +
                        "change the perceived gender of the voice to feminine. " +
                        "If it is not the case for you, just pursue different target values " +
                        "\n\n" +
                        "For each parameter, there would be an explanation that sets the framework, " +
                        "and then, there would be several exercises that are made with the ultimate goal " +
                        "of helping you make sense of your own voice. After completing all exercises, " +
                        "you will gain the understanding of how you can change your voice in a desired way. " +
                        "The only thing that will be left to do is to build necessary muscles by " +
                        "practicing the voice over and over again " +
                        "\n\n" +
                        "We're gonna go over each parameter and exercise our basic human right to uncanny speech! " +
                        "\n\n" +
                        "During the exercises, you may feel emotions like awkwardness, cringe, " +
                        "and hysterical possession. Embrace them. " +
                        "\n\n" +
                        "Good patience! ",
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
                "" +
                        "Turbulent airflow and vocal chords vibrations are producing sound. " +
                        "Later, this sound gets modified by resonance. " +
                        "Resonance is the only thing that differentiate sounds " +
                        "inside (not between) the groups of " +
                        "vowels, fricatives syllables, and occlusive syllables " +
                        "\n\n" +
                        "The resonant profile of a human voice has 4 distinct resonant zones, " +
                        "called formants: F1, F2, F3, F4 " +
                        "\n\n" +
                        "F3 and F4 do not really affect gender perception, so we're " +
                        "not gonna discuss them, instead, we'll focus on F1 and F2 only. " +
                        "Namely, F1 and F2 are the formants that are responsible for " +
                        "the difference between vowels " +
                        "\n\n" +
                        "So, what are those formants? " +
                        "\n\n" +
                        "Formant is a zone on a spectrum (from X Hz to Y Hz) that amplifies frequencies. " +
                        "We can see the presence of formants by introducing the white noise " +
                        "and measuring how it gets amplified " +
                        "\n\n" +
                        "Here are the Spectrogram and the Energy Spectrogram. Hit the record button and " +
                        "whisper wA, wI, wO, wU. See how some regions of the spectrum gets amplified. " +
                        "F1 and F2 here are 2 of the strongest lines (sometimes, they may be very hard to see). " +
                        "(an Energy Spectrogram is just a standard Spectrogram with a filter that " +
                        "makes the energy distribution easier to see) ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            IntegratedEnergySpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "As you may see, each vowel corresponds to the specific set of values for F1 and F2. " +
                        "At the same time, those \"vowel specific values\" are higher for a feminine voice " +
                        "and lower for a masculine one. As an example, the formant values for a masculine A are " +
                        "600 and 1050, while for a feminine A they are 800 and 1350" +
                        "\n\n" +
                        "The resonance of a human voice tract is based entirely on its shape," +
                        "so, we will use the word Resonance interchangeably with the word Shape " +
                        "\n\n" +
                        "The resonance that affects gender perception of a voice " +
                        "can be controlled by: \n" +
                        "\n    * Larynx elevation" +
                        "\n    * Back of the tongue" +
                        "\n    * Mouth space" +
                        "\n\n" +
                        "Let's learn how to control the resonance!",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Resonance - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "As the first step, we need to learn how to elevate your larynx and the back of the tongue, " +
                        "effectively reducing the mouth space and rising the F1 and F2 " +
                        "\n\n" +
                        "While whispering wA, try to strain the muscles that you normally use to swallow to raise the larynx " +
                        "(do not hold the swallow). Place a finger on your larynx (do not push, just place) to " +
                        "sense weather or not it is raising " +
                        "\n\n" +
                        "Try different muscles to find the right ones to raise the larynx. " +
                        "When you will raise the larynx successfully, your wA will sound much softer than before " +
                        "\n\n" +
                        "Take a look at the Energy Spectrogram. While whispering wA, you will see " +
                        "the F1 line probably somewhere between 500 and 2000. This line will go higher " +
                        "than it used to if you're successfully raising your larynx ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedEnergySpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "If you struggle to make the wA softer, try making a hissing sound while again " +
                        "straining the muscles that you normally use to swallow. Make sure that you " +
                        "straining the muscles at the very back of your mouth (not the front or the middle) " +
                        "\n\n" +
                        "Try until you'll be able to soften your voice consistently " +
                        "\n\n" +
                        "At first, the voice softening would be really difficult and you will struggle to hold " +
                        "the muscles at the right position for long, but keep practicing and " +
                        "eventually it will become effortless and automatic ",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Resonance - Exercise 2",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Now, let's add a pitch to the equation!" +
                        "\n\n" +
                        "We hope that now you're understanding how to make your whispered voice softer. " +
                        "So, let's do the same thing, but at this time, say an A at loud! " +
                        "\n\n" +
                        "Start from whispering wA again. At the middle of whispering wA, gently switch to a normal A. " +
                        "Place a finger on your larynx to make sure that it is not going down when you're making the switch " +
                        "\n\n" +
                        "Keep practicing until you are able to start pronouncing the A softly (with a high resonance). " +
                        "After that, try changing the resonance up and down while you pronouncing the A " +
                        "\n\n" +
                        "Say an A or an I and take a look at the Energy Spectrogram. " +
                        "As you may see, there are some formant lines in the 500 - 2000 Hz region (for the A). " +
                        "They are the same resonance indicators as they were before, but this time, they might " +
                        "be more consolidated into the actual lines. Your goal is to move your resonance to " +
                        "the default zone of the desired gender perception. " +
                        "Remember, default formant values are different for each vowel. ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedVowelGenderAnalysis()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Resonance - Exercise 3",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "You have learned how to speak with different resonance values " +
                        "in the previous exercise. Now, we're gonna make sure that you're " +
                        "actually utilizing the resonance, not the pitch... " +
                        "\n\n" +
                        "Your goal is to practice changing the resonance while " +
                        "holding the pitch at the same level, i.e. your pitch should not change while you " +
                        "changing the resonance (making the voice harder / softer). " +
                        "Hold an A, I, O, U while changing the resonance up and down ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedVowelGenderAnalysis()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Resonance - Exercise 4",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "If you have successfully completed all previous exercises - congratulations! " +
                        "You have mastered a static resonance! Now, it is time to practice speech " +
                        "\n\n" +
                        "The resonance charts from before will not really work for the speech, so " +
                        "you'll have to practice it relying solely on your feelings for the resonance, " +
                        "which I am sure you already have! " +
                        "\n\n" +
                        "The Pitch Graph still works fine for a speech tho, so you can use it as a tool to make sure " +
                        "that you're not overusing the Pitch instead of changing the Resonance ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedPitchGraph()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $" +
                        "\n\n" +
                        "Remember, the muscle building takes time. Keep practicing the resonance, it is the most " +
                        "important factor for achieving the desired gender perception! " +
                        "\n\n" +
                        "Yaay!",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Pitch",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Pitch is the most obvious voice parameter to perceive. " +
                        "Since you're here, we're pretty sure that you already have some idea of what is a Pitch. " +
                        "So, it is time to go much deeper and fully understand it! " +
                        "\n\n" +
                        "The vocal chords are vibrating because the air is passing through them. " +
                        "The vocal chords have specific muscles that can control their tension, " +
                        "which changes the frequency of the vibrations a.k.a. changes the Pitch " +
                        "\n\n" +
                        "There are 4 registers of pitch, which are made by different groups of muscles: \n" +
                        "\n    * Fry " +
                        "\n    * Modal " +
                        "\n    * Falsetto " +
                        "\n    * Whistle " +
                        "\n\n" +
                        "The Fry register is the lowest possible sound that is made by non strained vocal chords " +
                        "\n\n" +
                        "The Modal register voice is one of two the most common voice registers. " +
                        "It is on the lower side (typically < 250Hz) " +
                        "\n\n" +
                        "The Falsetto register is the second most typical voice register. " +
                        "It is on the higher side (typically > 250Hz) " +
                        "\n\n" +
                        "The Whistle register can be accessed only by children and people who have trained " +
                        "vocal muscles. It is not a typical register for a voice by any meaning " +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "For achieving the desired gender perception of the voice, it is important " +
                        "to keep the pitch inside the default range of the desired gender, however " +
                        "it is also important to understand that sometimes it is better to leave your pitch inside a " +
                        "specific register to achieve a more natural sounding, instead of forcing a specific range " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Pitch - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "For our first pitch exercise, let's just train the range" +
                        "\n\n" +
                        "Here is the Spectrogram and the Pitch graph. Say an A and see the harmonics (lines) " +
                        "appear on the spectrogram. The bottom line is the H1 a.k.a. Pitch. " +
                        "Move the pitch higher and lower as far as possible to train the full range. " +
                        "You can focus only on achieving the desired range if you really want to ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            IntegratedPitchGraph()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "(The pitch detection might get really flimsy if you will go above 512 Hz. " +
                        "We're working on it. You can help us by joining our team. " +
                        "Just send us a message and we'll respond to you with an extra happiness)",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Pitch - Exercise 2",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "For our second exercise, let's learn how to change pitch while " +
                        "staying inside the same register" +
                        "\n\n" +
                        "Say an A, I, O, U and slowly move your pitch from lowest to highest frequency " +
                        "and vice versa. Take a look at the charts, you'll notice a voice crack appears " +
                        "when the voice switches registers (around 250 Hz you'll see a gap in harmonic lines). " +
                        "After you notice the crack, try moving the pitch while staying within a single register " +
                        "(without cracking a voice). Your goal is to move the boundaries of the " +
                        "Modal and Falsetto registers closer together (they may overlap, that's good) ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedPitchGraph()
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Now, try speaking with the borderline pitch. Use the following text if you have nothing to say: " +
                        "\n\n" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Subtone",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Subtone does not really affect gender perception of a voice, but " +
                        "I think, it is important to still explore it to gain a full understanding " +
                        "\n\n" +
                        "The vocal chords have 2 distinct types of closure: Adductive and Abductive" +
                        "\n\n" +
                        "The Adductive closure is when the vocal chords are fully connected together " +
                        "and the airways are fully blocked by them. In this case, the amount of air that " +
                        "is pushed through them is proportional to the air pressure, which is proportional to the loudness " +
                        "\n\n" +
                        "The Abductive closure is when the vocal chords are only partially connected " +
                        "and more air can pass through them without increasing the pressure and the loudness. " +
                        "In this case, the portion of white noise in a voice is increased, " +
                        "making the voice sound more airy " +
                        "\n\n" +
                        "The sound production with Abductive closure of the vocal chords is called Subtone " +
                        "\n\n" +
                        "The Subtone sometimes is used in acting for an epic effect! " +
                        "and tbh it is cool to just occasionally talk like this " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Subtone - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Let's learn how to speak with a Subtone" +
                        "\n\n" +
                        "While pronouncing a standard A, exhale the additional air. " +
                        "You'll hear the subtoned sound. In this configuration we're doing a forced subtone " +
                        "by building up additional pressure in order to push more air through the vocal chords. " +
                        "Try relaxing the vocal chords closure muscles, but keep the same pitch, " +
                        "this way you can achieve an effortless Subtone production. " +
                        "When you're speaking with a Subtone, you may see an additional noise " +
                        "(light areas around the harmonic lines) on the spectrogram below ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedPitchGraph()
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Prosody",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "People usually assign many different meanings to Prosody, " +
                        "but in our case, we will talk about it as " +
                        "a technical measure of how much a pitch changes during speech " +
                        "\n\n" +
                        "Prosody does affect the gender perception of a voice, but not much. " +
                        "Feminine voices tends to have higher prosody and " +
                        "masculine voices tends to have lower prosody " +
                        "\n\n" +
                        "Prosody, despite being simple enough to measure, is a complex behaviour mechanism " +
                        "that serves as a way to express emotions and meanings. " +
                        "Meanwhile, some people are prosody-insensitive (they do not have an " +
                        "emotional connection between prosody and their emotional expressions), " +
                        "so they tend to have their own way of speaking with a certain prosody " +
                        "that is not attached to anything " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Prosody - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "As we already established, the prosody in our context is " +
                        "a simple measurement of changes in pitch. " +
                        "So now, try speaking with a rapidly changing or a flat pitch. " +
                        "See how the dynamic of changes in a pitch affects prosody ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedPitchGraph()
            IntegratedProsodyGraph()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Twang",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Twang is a special type of resonance that occurs when a person " +
                        "uses the specific muscles inside the throat or the nose to " +
                        "partially occlude the airways, creating a sharp nasal sound " +
                        "\n\n" +
                        "Twang is not affecting the gender perception of a voice, but " +
                        "it has a great effect on overall perception. " +
                        "A high value of twang can make a voice to be perceived as artificial or played ",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Twang - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "The easiest way to find a Twang, is to mimic the sound of a cat. " +
                        "Say prolonged meow and pay attention to the vibrations at the very back of your mouth," +
                        "that is gonna be the Twang. " +
                        "\n\n" +
                        "As the next step, try saying an A, I, O, U with and without twang. " +
                        "Also try speaking with and without twang ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Vocal Weight",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Vocal weight is the second most important parameter for achieving " +
                        "the desired gender perception of a voice " +
                        "\n\n" +
                        "Vocal Weight is also known as Thickness. In this guide, we're gonna call " +
                        "a voice with a High Vocal Weight as Thick and a voice with a Low Vocal Weight as Thin " +
                        "\n\n" +
                        "Vocal Weight is the measurement of buzziness of a voice, " +
                        "which is influenced by the tension of the peripheral " +
                        "vocal muscles around the vocal chords. " +
                        "There is a distinct switching point between thick and thin modes of a voice " +
                        "\n\n" +
                        "Masculine voices tends to be more buzzy than feminine voices " +
                        "\n\n" +
                        "We can see a presence of buzziness in a voice using the Spectrogram. " +
                        "The buzziness will show up as an additional noise around bottom harmonic lines, " +
                        "making the lines thicker " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Vocal Weight - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "As a starting point, we're gonna use a natural tendency of a voice " +
                        "to get lighter on higher pitches " +
                        "\n\n" +
                        "SAY an A and slide the PITCH UP while trying two things: " +
                        "Try maintaining the same thickness " +
                        "and try allowing your voice to naturally go thin on its own. " +
                        "Do not bring your pitch too high, it is better to avoid switching pitch registers. " +
                        "Your main goal here is to understand how is a thin and thick voice sounds like. " +
                        "\n\n" +
                        "Vocal Weight can be controlled by the group of muscles spatially close to the pitch muscles, " +
                        "but Vocal Weight is Not Pitch and Not Resonance. Remember it " +
                        "\n\n" +
                        "After you'll gain control over Vocal Weight in a higher pitch region, " +
                        "the next step is bringing the thinness to a lower pitch. " +
                        "Start from a thick and low sound. Bring it up and go thin. " +
                        "Then, bring the sound back, while maintaining its thinness. " +
                        "Take a look at the spectrogram. If you're bringing the thin sound down correctly, " +
                        "you'll see that harmonic lines are becoming thinner ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Vocal Weight - Exercise 2",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "When you're going from modal voice to falsetto and vice versa, " +
                        "you can hear the sharp switch that occurs. " +
                        "Our goal is to do the same thing but with the Vocal Weight " +
                        "\n\n" +
                        "Hold an A at the same pitch and try to use your previous knowledge of " +
                        "muscles to go from thick to thin. If you struggle to make it, " +
                        "exhale short bursts of air (do not hiss them), " +
                        "they're supposed to help you to go thin " +
                        "If you're successfully lowering your Voice Weight, " +
                        "the harmonic lines on the spectrogram will stay on the same level, " +
                        "but they'll become thinner ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Now, let's make sure that we're actually doing the right thing. " +
                        "There is an important difference between breathy thinness and true true thinness. " +
                        "Breathy thinness is when you utilizing the resonance instead of " +
                        "the vocal chords peripheral muscles " +
                        "\n\n" +
                        "When you're doing a breathy thinness, you still in a thick mode and " +
                        "it is very difficult to gracefully start a sound. " +
                        "When you're in a true thin mode, you can start sounds really smooth " +
                        "\n\n" +
                        "Try to blandly start an A sound. If you can slowly move from silence to sound, " +
                        "it means that you're in a thin mode. The abrupt start of the sound means a thick mode " +
                        "\n\n" +
                        "Practice thinness and thickness and don't forget to check yourself " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Vocal Weight - Exercise 3",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Now, we are gonna use a semi-occlusion technique to find thinness " +
                        "\n\n" +
                        "Say an M sound with your lips closed, then try to go thin. " +
                        "You'll hear how the sound changes from sharp and buzzy to more gentle and smooth. " +
                        "\n\n" +
                        "The important part here is that you need to watch closely for an M sound. " +
                        "If your sound changes form M to something breathy in between an M and N - " +
                        "you're doing a thin M incorrectly. " +
                        "You need to stay inside the M sound, but make it thin " +
                        "\n\n" +
                        "You can also do this with an initial N sound. " +
                        "And also you can block one or both of your nostrils (not fully) " +
                        "to build up a pressure, which will help you find thinness more easily " +
                        "\n\n" +
                        "When you're gonna succeed with finding a thin M or N, " +
                        "try slowly opening your mouth while maintaining thinness. " +
                        "You'll hear an A or AE ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "False Vocal Chords",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "False Vocal Chords a.k.a. the False Folds are not very influential to a gender perception of a voice, " +
                        "however, they are the most important parameter for achieving a natural sounding voice " +
                        "\n\n" +
                        "The engaged False Folds are making a sound tense, tight, chocked, constraint, labored " +
                        "\n\n" +
                        "The False Folds may seem close to the vocal weight, and they are related in some ways, " +
                        "but actually, it is a different parameter " +
                        "\n\n" +
                        "The False Folds feel higher in the throat compared to the Vocal Chords " +
                        "\n\n" +
                        "Retraction of the False Folds is an act of effort, not the absence of constriction " +
                        "\n\n" +
                        "The False Folds tends to engage during high resonance, so it is a challenge to " +
                        "overcome this natural tendency during a feminizing voicetraining " +
                        "\n\n" +
                        "Accidental False Folds constriction is one of the most common mistakes during " +
                        "a voicetraining / voice alteration process " +
                        "\n\n" +
                        "In this chapter, we're gonna use the terms Constriction and Retraction to " +
                        "refer to the False Folds's state " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "False Vocal Chords - Exercise 1",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Stick out your tongue and squeeze the airstream as you exhale. " +
                        "Try using the deepest part of your throat to do so. Feel the constriction. " +
                        "After you squeezed the airstream, reverse the action to fully open your airways." +
                        "Feel the retraction " +
                        "\n\n" +
                        "Then, try saying an A after you open your airstream. You will hear the clean soft sound. " +
                        "Practice keeping the sound clean. You may do so even without sticking out your tongue, " +
                        "just make sure that you're not accidentally squeezing the airflow with your tongue " +
                        "\n\n" +
                        "You should see less noise on the spectrogram when you're speaking with retraction ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "False Vocal Chords - Exercise 2",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Plug your ears with your fingers or with something else. " +
                        "Say an H sound and then try to squeeze and squeeze the airflow " +
                        "in the back of your throat, as you did it before. " +
                        "You'll hear the sound that can be either constrained and squeezed or " +
                        "unconstrained and almost inaudible. " +
                        "If the sound is unconstrained, it means that you're successfully retracting " +
                        "the vocal folds and vice versa. " +
                        "\n\n" +
                        "Plugging the ears helps us isolate the sound made by the False Folds from the turbulence. " +
                        "Many people describe the feeling of retraction as a feeling of " +
                        "widening / cooling / smiling inside the throat. " +
                        "You can try using short gasps to achieve an automatic retraction. " +
                        "Practice switching between constriction and retraction while pronouncing an H " +
                        "\n\n" +
                        "The spectrogram will help you see the noise ",
            )

            Spacer(modifier = Modifier.height(36.dp))
            IntegratedSpectrogram()
            Spacer(modifier = Modifier.height(36.dp))
            IntegratedRecordingControls()
            Spacer(modifier = Modifier.height(36.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Then, practice speaking with constricted or retracted vocal folds " +
                        "\n\n" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Front Muscles and Speaking Patterns",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "As you can see, in this guide we covered a lot of parameters that are " +
                        "influencing gender perception of a voice " +
                        "\n\n" +
                        "All covered parameters are controlled by the structures at the back of the mouth " +
                        "and the throat area. They're responsible for 80%+ of gender perception. " +
                        "Another 10% are behaviour patterns, which are tied with your personality, not your skills. " +
                        "And the final 10% are tied with the structures at the front of your mouth, " +
                        "let's call them FMIVP (Front Muscle Influenced Voice Parameters) ... " +
                        "\n\n" +
                        "It is important to know that FMIVP exist. " +
                        "There are some examples: \n" +
                        "\n    * Sharpness / Dullness " +
                        "\n    * Projected R / Muffled R " +
                        "\n    * Aspiration " +
                        "\n    * Nasalization " +
                        "\n\n" +
                        "Some FMIVP can influence the gender perception of a voice. " +
                        "However, we are not gonna talk about them in this guide for a good reason. " +
                        "FMIVP are not universal for all people. The defaults of FMIVP values are completely tied " +
                        "to a specific language and an accent that the person is talking with. " +
                        "The subtle difference in FMIVP between genders is often overshadowed by a multitude of factors, " +
                        "that are way different from what we are covering here FMIVP deserve their own guide! " +
                        "\n\n" +
                        "So yeah, the FMIVP are acknowledged! " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Voicetraining progression",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Conclusion" +
                        "\n\n" +
                        "In this short guide we've explored the basic parameters of a human " +
                        "voice, and how some of them are affecting the gender perception of the voice" +
                        "\n\n" +
                        "Now, We have some Tips&Tricks for You!" +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Day to Day training",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "We already said so, but it is important to say it again. " +
                        "Oftentimes it is physically impossible for an unvoicetrained individual " +
                        "to just hop in and start speaking with a desired voice, " +
                        "because doing so requires muscles, which we need to build first. " +
                        "\n\n" +
                        "It is possible to build the necessary muscles by doing voicetraining a.k.a. practicing. " +
                        "The muscle building can take about a month or several. " +
                        "Once muscles are built, they will never go away if " +
                        "you will use them for your desired voice on a daily basis " +
                        "\n\n" +
                        "Warmups are important. Start your voicetraining sessions from a light exercises " +
                        "and then gradually increase the difficulty " +
                        "\n\n" +
                        "Awareness is the key to progress. Keep in mind, that you can always spent " +
                        "enormous amounts of effort just to achieve nothing, because " +
                        "a voicetraining, as any other area of life, does not appreciate people who work hard. " +
                        "If you want to achieve a meaningful results, you need to first build " +
                        "the understanding of the system that you dealing with. " +
                        "Work Hard and Work Smart - this is the only path to success! " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Recording the progress",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "Recording your progress is very important to success, " +
                        "because only this way you can truly see the changes and the progress " +
                        "\n\n" +
                        "Record your best moments so you can go back to them if you ever feel lost " +
                        "\n\n" +
                        "The app has all necessary features to make a recording process as easy as possible. " +
                        "Use the save button on the recording bar and access your recordings through the recordings menu " +
                        "\n\n" +
                        "If the dysphoria hits you hard whenever you're listening to your voice, " +
                        "then I (Ketaslava Ket) really wanna say that I support you " +
                        "and wish you a voice that you will like! Keep going and I believe in you! " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Tips&Tricks, Avoiding Mistakes",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "1. It is a good idea to have a foundational phrase that you will use " +
                        "as a sample text that you can say on demand. This way, it will be easier for you " +
                        "to quickly come back to your voice and to focus on details rather than on pronunciation " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Refinement and Normalization",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "There is a very common myth that you can often hear about many things, " +
                        "including a voicetraining. It says that \"You can never achieve a 100% result " +
                        "in changing a behaviour. No matter what you do, there always would be some " +
                        "part that will stay unchangeable. The first acquired behaviour is " +
                        "hardwired inside the brain forever.\" This is an incorrect statement " +
                        "\n\n" +
                        "Any acquired behaviour forms a neural pathways inside your brain, and any means any. " +
                        "There is no fundamental difference between the first acquisition and all the next. " +
                        "Even if the first behaviour will not be completely overwritten, the new behaviour " +
                        "still can fully displace the old through an overcorrection " +
                        "\n\n" +
                        "The overcorrection is a situation when the features of a new behavior are " +
                        "amplified beyond 100%. As an example: If you want to feminize a masculine voice, " +
                        "there is a good reason to learn a hyper feminine voice. The hyper feminine voice " +
                        "will be the overcorrective behaviour that will lay on top of the old masculine voice " +
                        "resulting in a voice baseline shift to a normal feminine voice " +
                        "\n\n" +
                        "This logic is fully applicable to any human behaviour, " +
                        "including habits, routines, accents, thoughts, etc. " +
                        "The core struggle here is to gain a sufficient conscious understanding of a behaviour " +
                        "that we want to correct in order to apply overcorrective measures. " +
                        "Pure mimicry without conscious understanding will not be able to produce " +
                        "an overcorrective behaviour most of the time " +
                        "\n\n" +
                        ". . ." +
                        "\n\n" +
                        "The prevalent behaviour is always amplifies itself. If you're speaking with a new " +
                        "voice only occasionally, it will experience a constant suppression by the old voice, " +
                        "and it will tend to disappear over time. However, if you'll use the new voice more than " +
                        "51% of the time, it will amplify itself and it will suppress the old voice, " +
                        "over time making itself the new baseline " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
        {
            Spacer(modifier = Modifier.height(24.dp))

            readerComponents.HeaderTextBlock_Centred(
                "Credits, Peace!",
            )

            Spacer(modifier = Modifier.height(32.dp))

            readerComponents.TextBlock_AlignedStart(
                "" +
                        "That was the Gender Affirming Voicetraining Guide " +
                        "for OpenAudioTools " +
                        "\n\n" +
                        "The guide was made by Ketaslava Ket and KTVINCCO Team " +
                        "\n\n" +
                        "We hope you've enjoyed it! " +
                        "\n\n" +
                        "We're really want to say a Big Thank You to all creators who are inspired our work " +
                        "with a good knowledge and accessible materials. They are probably have " +
                        "absolutely no idea about our existence, but we want to give them a credit: \n" +
                        "\n    * YukkoEX " +
                        "\n    * Zheanna Erose from TranVoiceLessons.com " +
                        "\n    * FairyPrincessLucy " +
                        "\n    * AYSL " +
                        "\n\n" +
                        "Yaay " +
                        "\n\n" +
                        "Peace! " +
                        "",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
    )


    @Composable
    fun IntegratedSpectrogram() {

        val pointerPosition = modelData.pointerPosition.collectAsState().value
        val dataDurationSec = modelData.dataDurationSec.collectAsState().value
        val recordingState = modelData.recordingState.collectAsState().value
        val spectrogramData = modelData.getSpectrogramData("SpectrogramInHz")

        graphNameText(modelData, "SpectrogramInHz")

        Spectrogram().Draw(
            data = spectrogramData,
            modelData = modelData,
            xLabelMin = 0F,
            xLabelMax = dataDurationSec,
            yLabelMin = 0F,
            yLabelMax = 4096F,
            horizontalLinesCount = 8,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            pointerPosition = pointerPosition,
            isEnableAutoScroll = recordingState,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )
    }


    @Composable
    fun IntegratedEnergySpectrogram() {

        val pointerPosition = modelData.pointerPosition.collectAsState().value
        val dataDurationSec = modelData.dataDurationSec.collectAsState().value
        val recordingState = modelData.recordingState.collectAsState().value
        val energySpectrogramData = modelData.getSpectrogramData("EnergySpectrogramInHz")

        graphNameText(modelData, "SpectrogramInHz")

        Spectrogram().Draw(
            data = energySpectrogramData,
            modelData = modelData,
            xLabelMin = 0F,
            xLabelMax = dataDurationSec,
            yLabelMin = 0F,
            yLabelMax = 4096F,
            horizontalLinesCount = 8,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            pointerPosition = pointerPosition,
            isEnableAutoScroll = recordingState,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )
    }


    @Composable
    fun IntegratedPitchGraph() {

        val pointerPosition = modelData.pointerPosition.collectAsState().value
        val dataDurationSec = modelData.dataDurationSec.collectAsState().value
        val recordingState = modelData.recordingState.collectAsState().value
        val pitchData = modelData.getGraphData("Pitch")

        graphNameText(modelData, "Pitch")

        Graph().Draw(
            data = pitchData,
            modelData = modelData,
            xLabelMax = dataDurationSec,
            yLabelMin = 50F,
            yLabelMax = 500F,
            horizontalLinesCount = 9,
            pointerPosition = pointerPosition,
            graphZones = listOf(
                GraphZone(
                    minLabel = 175F,
                    maxLabel = 350F,
                    color = ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                )
            ),
            isEnableAutoScroll = recordingState,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
    }


    @Composable
    fun IntegratedProsodyGraph() {

        val pointerPosition = modelData.pointerPosition.collectAsState().value
        val dataDurationSec = modelData.dataDurationSec.collectAsState().value
        val recordingState = modelData.recordingState.collectAsState().value
        val prosody = modelData.getGraphData("Prosody")

        graphNameText(modelData, "Prosody")
        Graph().Draw(
            data = prosody,
            modelData = modelData,
            xLabelMax = dataDurationSec,
            pointerPosition = pointerPosition,
            graphZones = listOf(
                GraphZone(
                    minLabel = 0.25F,
                    maxLabel = 0.75F,
                    color = ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)
                )
            ),
            isEnableAutoScroll = recordingState,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }


    @Composable
    fun IntegratedVowelGenderAnalysis() {

        var targetMode by remember { mutableStateOf("Feminine A") }

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BasicComponents().Button(modelData, text = "Feminine A",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Feminine A" }

            BasicComponents().Button(modelData, text = "Enby A",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Enby A" }

            BasicComponents().Button(modelData, text = "Masculine A",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Masculine A" }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BasicComponents().Button(modelData, text = "Feminine I",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Feminine I" }

            BasicComponents().Button(modelData, text = "Enby I",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Enby I" }

            BasicComponents().Button(modelData, text = "Masculine I",
                modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth().weight(1f)) {
                targetMode = "Masculine I" }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val f1Zones = when (targetMode) {
            "Feminine A" -> listOf(GraphZone(700F, 900F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby A" -> listOf(GraphZone(600F, 800F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine A" -> listOf(GraphZone(500F, 700F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Feminine I" -> listOf(GraphZone(350F, 550F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby I" -> listOf(GraphZone(250F, 450F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine I" -> listOf(GraphZone(150F, 350F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            else -> listOf()
        }

        val f2Zones = when (targetMode) {

            "Feminine A" -> listOf(GraphZone(1200F, 1500F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby A" -> listOf(GraphZone(1050F, 1350F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine A" -> listOf(GraphZone(900F, 1200F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Feminine I" -> listOf(GraphZone(2200F, 2800F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby I" -> listOf(GraphZone(2000F, 2600F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine I" -> listOf(GraphZone(1800F, 2400F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            else -> listOf()
        }

        val pitchZones = when (targetMode) {
            "Feminine A" -> listOf(GraphZone(175F, 350F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby A" -> listOf(GraphZone(140F, 185F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine A" -> listOf(GraphZone(50F, 150F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Feminine I" -> listOf(GraphZone(175F, 350F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Enby I" -> listOf(GraphZone(140F, 185F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            "Masculine I" -> listOf(GraphZone(50F, 150F,
                ColorPalette.getSoftGreenColor().copy(alpha = 0.25F)))

            else -> listOf()
        }

        val pointerPosition = modelData.pointerPosition.collectAsState().value
        val dataDurationSec = modelData.dataDurationSec.collectAsState().value
        val recordingState = modelData.recordingState.collectAsState().value

        val pitchData = modelData.getGraphData("Pitch")
        graphNameText(modelData, "Pitch")
        Graph().Draw(
            data = pitchData,
            modelData = modelData,
            xLabelMax = dataDurationSec,
            yLabelMin = 50F,
            yLabelMax = 500F,
            horizontalLinesCount = 9,
            pointerPosition = pointerPosition,
            graphZones = pitchZones,
            isEnableAutoScroll = recordingState,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )

        val energySpectrogramData = modelData.getSpectrogramData("EnergySpectrogramInHz")
        graphNameText(modelData, "SpectrogramInHz")
        Spectrogram().Draw(
            data = energySpectrogramData,
            modelData = modelData,
            xLabelMin = 0F,
            xLabelMax = dataDurationSec,
            yLabelMin = 0F,
            yLabelMax = 4096F,
            horizontalLinesCount = 8,
            graphZones = f1Zones + f2Zones,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            pointerPosition = pointerPosition,
            isEnableAutoScroll = recordingState,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )

        val activeFirstFormantGraph = modelData.getGraphData("ActiveFirstFormant")
        graphNameText(modelData, "ActiveFirstFormant")
        Graph().Draw(
            data = activeFirstFormantGraph,
            modelData = modelData,
            xLabelMax = dataDurationSec,
            yLabelMax = 4096F,
            horizontalLinesCount = 16,
            pointerPosition = pointerPosition,
            isEnableAutoScroll = recordingState,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            graphZones = f1Zones,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )

        val activeSecondFormantGraph = modelData.getGraphData("ActiveSecondFormant")
        graphNameText(modelData, "ActiveSecondFormant")
        Graph().Draw(
            data = activeSecondFormantGraph,
            modelData = modelData,
            xLabelMax = dataDurationSec,
            yLabelMax = 4096F,
            horizontalLinesCount = 16,
            pointerPosition = pointerPosition,
            isEnableAutoScroll = recordingState,
            autoScrollXWindowSize = Configuration.getAutoScrollXWindowSize(),
            graphZones = f2Zones,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
        )
    }


    @Composable
    fun IntegratedRecordingControls() {
        RecordingControl(modelData).Draw()
    }
}