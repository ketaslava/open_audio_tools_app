package com.ktvincco.openaudiotools.ui.user_guide_pages

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource


class TheGuideIsFinishedPage (
    private val modelData: ModelData
) {


    @Composable
    fun Draw() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorPalette.getBackgroundColor())
                .verticalScroll(rememberScrollState())
        ) {
            Content()
        }
    }


    @Composable
    fun Content() {

        // -------------------- Hello and Welcome -------------------- //

        Spacer(modifier = Modifier.height(24.dp))

        DynamicText(
            text = "The Guide is Finished!",
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
            text = "Congrats!" +
                    "\n\n" +
                    "Use the bottom menu to Navigate the App",
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

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(Res.drawable.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                null,
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
            )
        }

        Spacer(modifier = Modifier.height(96.dp))
    }
}
