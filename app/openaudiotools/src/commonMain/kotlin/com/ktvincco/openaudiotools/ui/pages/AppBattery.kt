package com.ktvincco.openaudiotools.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.components.BasicComponents


class AppBattery (
    private val modelData: ModelData
) {

    @Composable
    fun Draw() {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            val isWideScreen = maxWidth > maxHeight
            val scrollState = rememberScrollState()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxHeight()
                        .then(
                            if (isWideScreen) {
                                Modifier.aspectRatio(1F)
                            } else {
                                Modifier.fillMaxWidth()
                            }
                        )
                        .verticalScroll(state = scrollState)
                ) {

                    Spacer(modifier = Modifier.height(24.dp))

                    HeaderTextBlock_Centred("App Battery")

                    Spacer(modifier = Modifier.height(32.dp))

                    val batteryText by modelData.appBatteryTimeText.collectAsState()
                    val batteryCharge by modelData.appBatteryCharge.collectAsState()

                    AppBatteryIndicator("$batteryText days", batteryCharge) {}

                    Spacer(modifier = Modifier.height(32.dp))

                    TextBlock_Centred(
                        "" +
                                "Fight fire with fire!" +
                                "\n\n" +
                                "Watch just One full screen ad to Disable All Ads and Enable All Features for an Entire Day!"
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    val isAdLoading by modelData.isAdLoading.collectAsState()
                    val buttonText = if (isAdLoading) "Loading AD..." else "Watch one AD"

                    BasicComponents().Button(
                        modelData, text = buttonText,
                        isAppearActive = !isAdLoading,
                        modifier = Modifier.heightIn(min = 64.dp).fillMaxWidth(),
                        buttonColor = Color.hsl(240F, 0.5F, 0.5F)
                    ) {
                        modelData.watchScreenBlockingAd()
                    }
                }
            }
        }
    }


    @Composable
    public fun AppBatteryIndicator(
        text: String,
        charge: Float,
        onClick: () -> Unit
    ) {

        val volumeColor = Color.hsv(0F, 0F, 0.16F)
        val chargedColor = Color.hsv(120F, 0.5F, 0.75F)
        val unchargedColor = Color.hsv(0F, 0.75F, 0.75F)

        val pimpColor = if (charge == 1F) { chargedColor } else { volumeColor }
        val chargeColor = if (charge == 0F) { unchargedColor } else { chargedColor }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clickable { onClick() }
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = volumeColor)
                    .border(width = 2.dp, color = Color.White,
                        shape = RoundedCornerShape(8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth((charge + 0.05F).coerceIn(0f, 1f))
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = chargeColor)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    TextBlock_Centred(text)
                }
            }
            Box (
                modifier = Modifier
                    .height(24.dp)
                    .width(12.dp)
                    .clip(shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                    .background(color = pimpColor)
                    .border(width = 2.dp, color = Color.White,
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
            ) {}
        }
    }


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