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
import com.ktvincco.openaudiotools.ui.components.ReaderComponents
import com.ktvincco.openaudiotools.Res
import com.ktvincco.openaudiotools.arrow_downward_24dp_e8eaed_fill0_wght400_grad0_opsz24
import com.ktvincco.openaudiotools.keta_with_a_magic_rod
import org.jetbrains.compose.resources.painterResource


class TheGuideIsFinishedPage (
    private val modelData: ModelData
) {


    val readerComponents = ReaderComponents(modelData)


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

        // -------------------- The Guide is Finished! -------------------- //

        Spacer(modifier = Modifier.height(24.dp))

        readerComponents.HeaderTextBlock_Centred(
            "The Guide is Finished!"
        )

        Spacer(modifier = Modifier.height(32.dp))

        readerComponents.TextBlock_Centred(
            "Congrats!" +
                    "\n\n" +
                    "Use the bottom menu to Navigate the App"
        )

        Spacer(modifier = Modifier.height(64.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(Res.drawable.keta_with_a_magic_rod),
                null,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(Res.drawable.arrow_downward_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                null,
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
            )
        }

        Spacer(modifier = Modifier.height(128.dp))
    }
}
