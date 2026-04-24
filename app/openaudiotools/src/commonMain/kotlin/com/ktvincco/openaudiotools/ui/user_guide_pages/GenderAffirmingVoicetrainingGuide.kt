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
                        "trough the power of Voicetraining" +
                        "\n\n" +
                        "We're gonna teach you a handful of tips and tricks on how to make your voice " +
                        "sound absolutely astonishing! " +
                        "\n\n" +
                        "We're put our best efforts in making this guide useful 4 U, and We hope that you'll enjoy it! " +
                        "Ngl, this guide is very complex, it involves a lot of in-depth theory and a lot of routine practice. " +
                        "We wish you high brain power and the great patience with the results! " +
                        "Don't forget to drink your water and take breaks as needed! " +
                        "\n\n" +
                        "We believe in You!" +
                        "\n\n" +
                        "btw, If you don't familiar with the Basics of the Voicetraining, " +
                        "We highly recommend you to take a General Voicetraining Guide first. TY!" +
                        "\n\n" +
                        "K..." +
                        "\n\n" +
                        "Let's GO!"
            )

            Spacer(modifier = Modifier.height(128.dp))
        },
    )
}