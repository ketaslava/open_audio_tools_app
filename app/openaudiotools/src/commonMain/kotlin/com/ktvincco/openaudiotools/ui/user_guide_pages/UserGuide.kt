package com.ktvincco.openaudiotools.ui.user_guide_pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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


class UserGuide (modelData: ModelData) : MultiPageReader(modelData) {


    override fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration(
        isEnableControls = false,
        isAllowBackButtonByState = true,
        isEnableNextButtonDestinationPage = true,
        nextButtonDestinationPageName = "TheGuideIsFinishedPage",
    )


    override fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf( {

        // -------------------- Hello and Welcome -------------------- //

        Spacer(modifier = Modifier.height(24.dp))

        DynamicText(
            text = "Hello!\nand Welcome to the OpenAudioTools!",
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
            text = "We're happy to see you!\n\n" +
                    "This app was created to to empower the user with absolutely fantastic tools to analyze sounds (especially human voices)\n\n" +
                    "And now, We're gonna explain to you How Does It Actually Works" +
                    "\n\n" +
                    "& How You can use Our App to reach Your Goals!" +
                    "\n\n" +
                    "Sooo..." +
                    "\n\n" +
                    "What's your goals are?",
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

        BasicComponents().Button(
            modelData,
            text = "Voice Improvement >",
            fontSize = 18.sp,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            modelData.navigation.setPreviousPage("UserGuide")
            modelData.openPage("GeneralVoicetrainingGuide")
        }

        Spacer(modifier = Modifier.height(16.dp))

        BasicComponents().Button(
            modelData,
            text = "Sound Analysis >",
            fontSize = 18.sp,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            modelData.navigation.setPreviousPage("UserGuide")
            modelData.openPage("SoundAnalysisGuide")
        }

        Spacer(modifier = Modifier.height(256.dp))
    })
}
