package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData


class ReaderComponents (
    private val modelData: ModelData
) {


    @Composable
    fun HeaderTextBlock_Centred(text: String) {
        DynamicText(
            text = text,
            modelData = modelData,
            color = ColorPalette.getTextColor(),
            fontSize = 28.sp,
            lineHeight = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
    }


    @Composable
    fun TextBlock_Centred(text: String) {
        DynamicText(
            text = text,
            modelData = modelData,
            color = ColorPalette.getTextColor(),
            fontSize = 18.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
    }
}