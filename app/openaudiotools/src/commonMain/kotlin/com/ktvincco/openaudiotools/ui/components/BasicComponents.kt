package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.check_box_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import openaudiotools.app.openaudiotools.generated.resources.check_box_outline_blank_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

class BasicComponents {


    @Composable
    fun Checkbox(text: String, modelData: ModelData,
                 modifier: Modifier, fontSize: TextUnit = 16.sp,
                 checkboxCodingColorForEnabled: Color = Color.White,
                 checkboxCodingColorForDisabled: Color = Color.White,
                 textCodingColorForEnabled: Color = ColorPalette.getTextColor(),
                 textCodingColorForDisabled: Color = ColorPalette.getTextColor(),
                 callback: (state: Boolean) -> Unit) {

        var isCheckboxChecked by remember { mutableStateOf(false) }

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    // Switch and emit callback
                    isCheckboxChecked = !isCheckboxChecked
                    callback.invoke(isCheckboxChecked)
                }
        ) {
            var icon = Res.drawable.check_box_outline_blank_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
            if (isCheckboxChecked) {
                icon = Res.drawable.check_box_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
            }
            val checkboxCodingColor = if (isCheckboxChecked) {
                checkboxCodingColorForEnabled
            } else {
                checkboxCodingColorForDisabled
            }
            Image(
                painterResource(icon),
                null,
                colorFilter = ColorFilter.tint(checkboxCodingColor),
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp)
                    //.background(Color.Magenta)
                    .clickable {
                        // Switch and emit callback
                        isCheckboxChecked = !isCheckboxChecked
                        callback.invoke(isCheckboxChecked)
                    }
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textCodingColor = if (isCheckboxChecked) {
                textCodingColorForEnabled
            } else {
                textCodingColorForDisabled
            }
            DynamicText(
                text = text,
                modelData = modelData,
                color = textCodingColor,
                fontSize = fontSize,
            )
        }
    }


    @Composable
    fun Button(
        modelData: ModelData,
        text: String,
        isAppearActive: Boolean = true,
        activeButtonColor: Color = ColorPalette.getButtonColor(),
        inactiveButtonColor: Color = ColorPalette.getButtonColor().copy(alpha = 0.33F),
        activeTextColor: Color = ColorPalette.getTextColor(),
        inactiveTextColor: Color = ColorPalette.getTextColor().copy(alpha = 0.33F),
        cornerRadius: Dp = 16.dp,
        fontSize: TextUnit = 16.sp,
        textPadding: Dp = 16.dp,
        modifier: Modifier,
        onClick: () -> Unit
    ) {

        var buttonColor = activeButtonColor
        var textColor = activeTextColor
        if (!isAppearActive) {
            buttonColor = inactiveButtonColor
            textColor = inactiveTextColor
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .clip(shape = RoundedCornerShape(cornerRadius))
                .background(buttonColor)
                .clickable {
                    onClick()
                }
        ) {
            DynamicText(
                text = text,
                isTranslatable = false,
                modelData = modelData,
                color = textColor,
                fontSize = fontSize,
                modifier = Modifier.padding(textPadding)
            )
        }
    }


    @Composable
    fun HorizontalDivider(
        modifier: Modifier = Modifier,
        thickness: Dp = DividerDefaults.Thickness,
        color: Color = DividerDefaults.color,
    ) = Canvas(modifier.fillMaxWidth().height(thickness)) {
        drawLine(
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(0f, thickness.toPx() / 2),
            end = Offset(size.width, thickness.toPx() / 2),
        )
    }

    @Composable
    fun VerticalDivider(
        modifier: Modifier = Modifier,
        thickness: Dp = DividerDefaults.Thickness,
        color: Color = DividerDefaults.color,
    ) = Canvas(modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(thickness.toPx() / 2, 0f),
            end = Offset(thickness.toPx() / 2, size.height),
        )
    }

    object DividerDefaults {
        val Thickness: Dp = 1.dp
        val color: Color = Color.White
    }
}