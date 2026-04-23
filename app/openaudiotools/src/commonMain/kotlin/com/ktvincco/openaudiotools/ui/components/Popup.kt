package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData

class Popup (private val modelData: ModelData) {

    @Composable
    fun Popup() {

        val isPopupOpened = modelData.isPopupOpened.collectAsState().value
        val popupHeadline = modelData.popupHeadline.collectAsState().value
        val popupText = modelData.popupText.collectAsState().value

        // Switch
        if (!isPopupOpened) { return }

        Box(
            Modifier.Companion
                .fillMaxSize()
                .background(Color.Companion.Black.copy(alpha = 0.5f))
                .clickable(
                    onClick = {},
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        ) {
            Column(
                Modifier.Companion
                    .fillMaxWidth(0.8f)
                    .wrapContentHeight()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(ColorPalette.Companion.getBlockColor())
                    .padding(16.dp)
                    .align(Alignment.Companion.Center),
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {
                DynamicText(
                    text = popupHeadline,
                    modelData = modelData,
                    style = MaterialTheme.typography.h6,
                    color = ColorPalette.Companion.getTextColor()
                )

                Spacer(Modifier.Companion.height(42.dp))

                DynamicText(
                    text = popupText,
                    modelData = modelData,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Companion.Center,
                    color = ColorPalette.Companion.getTextColor()
                )

                Spacer(Modifier.Companion.height(42.dp))

                Row(
                    Modifier.Companion.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                            .background(ColorPalette.Companion.getLightButtonColor())
                            .weight(1F)
                            .clickable { modelData.closePopup("Cancel") }
                    ) {
                        DynamicText(
                            text = "Cancel",
                            modelData = modelData,
                            color = ColorPalette.Companion.getTextColor()
                        )
                    }
                    Spacer(
                        modifier = Modifier.Companion
                            .width(16.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                            .background(ColorPalette.Companion.getLightButtonColor())
                            .weight(1F)
                            .clickable { modelData.closePopup("Ok") }
                    ) {
                        DynamicText(
                            text = "Ok",
                            modelData = modelData,
                            color = ColorPalette.Companion.getTextColor()
                        )
                    }
                }
            }
        }
    }


    @Composable
    fun PopupWithTextInput() {

        val isPopupWithTextInputOpened =
            modelData.isPopupWithTextInputOpened.collectAsState().value
        val popupHeadline =
            modelData.popupHeadline.collectAsState().value
        var textInput by remember { mutableStateOf("") }

        // Switch
        if (!isPopupWithTextInputOpened) { return }

        Box(
            Modifier.Companion
                .fillMaxSize()
                .background(Color.Companion.Black.copy(alpha = 0.5f))
                .clickable(
                    onClick = {},
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        ) {
            Column(
                Modifier.Companion
                    .fillMaxWidth(0.8f)
                    .wrapContentHeight()
                    .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                    .background(ColorPalette.Companion.getBlockColor())
                    .padding(16.dp)
                    .align(Alignment.Companion.Center),
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {
                DynamicText(
                    text = popupHeadline,
                    modelData = modelData,
                    style = MaterialTheme.typography.h6,
                    color = ColorPalette.Companion.getTextColor()
                )

                Spacer(Modifier.Companion.height(42.dp))

                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    placeholder = { Text("Enter the text") },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = ColorPalette.Companion.getTextColor(),
                        backgroundColor = ColorPalette.Companion.getBlockColor(),
                        cursorColor = ColorPalette.Companion.getTextColor(),
                        placeholderColor = ColorPalette.Companion.getTextColor()
                    ),
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                        .background(ColorPalette.Companion.getLightButtonColor())
                )

                Spacer(Modifier.Companion.height(42.dp))

                Row(
                    Modifier.Companion.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                            .background(ColorPalette.Companion.getLightButtonColor())
                            .weight(1F)
                            .clickable {
                                modelData.closePopupWithTextInput("Cancel", textInput)
                                textInput = ""
                            }
                    ) {
                        DynamicText(
                            text = "Cancel",
                            modelData = modelData,
                            color = ColorPalette.Companion.getTextColor()
                        )
                    }
                    Spacer(
                        modifier = Modifier.Companion
                            .width(16.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                            .background(ColorPalette.Companion.getLightButtonColor())
                            .weight(1F)
                            .clickable {
                                modelData.closePopupWithTextInput("Ok", textInput)
                                textInput = ""
                            }
                    ) {
                        DynamicText(
                            text = "Ok",
                            modelData = modelData,
                            color = ColorPalette.Companion.getTextColor()
                        )
                    }
                }
            }
        }
    }
}