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
                        "the desired voice perception; Resonance and Vocal Weight are " +
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
                        "makes the energy distribution easier to see) " +
                        "\n\n" +
                        "[PLACE THE SPECTROGRAM AND THE ENERGY SPECTROGRAM HERE]" +
                        "\n\n" +
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
                        "than it used to if you're successfully raising your larynx " +
                        "\n\n" +
                        "[PLACE THE ENERGY SPECTROGRAMS HERE]" +
                        "\n\n" +
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
                        "Say an A and take a look at the Energy Spectrogram. " +
                        "As you may see, there are some formant lines in the 500 - 2000 Hz region. " +
                        "They are the same resonance indicators as they were before, but this time, they might " +
                        "be more consolidated into the actual lines. Your goal is to move your resonance to " +
                        "the default zone of the desired gender perception. " +
                        "Remember, that formant values are different for each vowel. " +
                        "\n\n" +
                        "[PLACE THE ENERGY SPECTROGRAM AND THE F1 F2 RESONANCE CHART WITH A MARKINGS " +
                        "FOR A GENDER PERCEPTION ZONES HERE]" +
                        "",
            )

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
                        "Hold an A, I, O, U while changing the resonance up and down " +
                        "\n\n" +
                        "[PLACE THE PITCH GRAPH AND THE ENERGY SPECTROGRAM + F1 F2 CHART HERE]" +
                        "",
            )

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
                        "that you're not overusing the Pitch instead of changing the Resonance " +
                        "\n\n" +
                        "[PLACE THE PITCH GRAPH HERE]" +
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
                        "The vocal chords are vibrating because the air is passing trough them. " +
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
                        "You can focus only on achieving the desired range if you really want to " +
                        "\n\n" +
                        "[PLACE THE SPECTROGRAM AND THE PITCH GRAPH HERE]" +
                        "\n\n" +
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
                        "Modal and Falsetto registers closer together (they may overlap, that's good) " +
                        "\n\n" +
                        "[PLACE THE PITCH GRAPH AND THE SPECTROGRAM HERE]" +
                        "\n\n" +
                        "Now, try speaking with the borderline pitch. Use the following text if you have nothing to say: " +
                        "\n\n" +
                        "$ When the sunlight strikes raindrops in the air, they act as a prism and form a rainbow. " +
                        "The rainbow is a division of white light into many beautiful colors. " +
                        "These take the shape of a long round arch, with its path high above, " +
                        "and its two ends apparently beyond the horizon. $",
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
    )
}