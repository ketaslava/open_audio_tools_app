package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.Image
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
import com.ktvincco.openaudiotools.Texts
import com.ktvincco.openaudiotools.presentation.ModelData
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.star_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import openaudiotools.app.openaudiotools.generated.resources.star_24dp_E8EAED_FILL1_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource


class ReviewForm (
    private val modelData: ModelData,
) {

    @Composable
    fun draw() {

        // Get state
        val dialogState = modelData.reviewDialogState.collectAsState().value

        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    onClick = {},
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        ) {

            if (dialogState == "DoYouEnjoyUsingThisApp") {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "Do you enjoy using this app?",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState(
                                        "GreatWouldYouLikeToRateThisApp")
                                }
                        ) {
                            DynamicText(
                                text = "Yes",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }

                        Spacer(Modifier.width(16.dp))

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState(
                                        "WereSorryToHearThatWouldYouLikeToTellUsWhy")
                                }
                        ) {
                            DynamicText(
                                text = "No",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }
                    }
                }
            }


            if (dialogState == "GreatWouldYouLikeToRateThisApp") {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "Great!",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    DynamicText(
                        text = "Would you like to rate this app pls?",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(ColorPalette.getLightButtonColor())
                            .clickable {
                                modelData.setReviewDialogState("HowManyStars")
                            }
                    ) {
                        DynamicText(
                            text = "Yes!",
                            modelData = modelData,
                            color = ColorPalette.getTextColor()
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState("DoYouEnjoyUsingThisApp")
                                }
                        ) {
                            DynamicText(
                                text = "< Back",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }

                        Spacer(Modifier.width(16.dp))

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.reviewDialogWasCompleted("Later")
                                    modelData.setReviewDialogState("Closed")
                                }
                        ) {
                            DynamicText(
                                text = "Later",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }
                    }
                }
            }


            if (dialogState == "HowManyStars") {

                var starsCount by remember { mutableStateOf(0) }

                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "How Many Stars?",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        val emptyStar = painterResource(
                            Res.drawable.star_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24)
                        val filledStar = painterResource(
                            Res.drawable.star_24dp_E8EAED_FILL1_wght400_GRAD0_opsz24)

                        Image(
                            if (starsCount >= 1) filledStar else emptyStar,
                            null,
                            modifier = Modifier
                                .width(42.dp)
                                .height(42.dp)
                                .clickable {
                                    starsCount = 1
                                }
                        )
                        Image(
                            if (starsCount >= 2) filledStar else emptyStar,
                            null,
                            modifier = Modifier
                                .width(42.dp)
                                .height(42.dp)
                                .clickable {
                                    starsCount = 2
                                }
                        )
                        Image(
                            if (starsCount >= 3) filledStar else emptyStar,
                            null,
                            modifier = Modifier
                                .width(42.dp)
                                .height(42.dp)
                                .clickable {
                                    starsCount = 3
                                }
                        )
                        Image(
                            if (starsCount >= 4) filledStar else emptyStar,
                            null,
                            modifier = Modifier
                                .width(42.dp)
                                .height(42.dp)
                                .clickable {
                                    starsCount = 4
                                }
                        )
                        Image(
                            if (starsCount >= 5) filledStar else emptyStar,
                            null,
                            modifier = Modifier
                                .width(42.dp)
                                .height(42.dp)
                                .clickable {
                                    starsCount = 5
                                }
                        )
                    }

                    Spacer(Modifier.height(42.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(ColorPalette.getLightButtonColor())
                            .clickable {

                                // Process input
                                if (starsCount == 0) { return@clickable }

                                // Submit rating
                                modelData.formSubmitted(mapOf(
                                    "formType" to "feedbackRating",
                                    "starsCount" to starsCount.toString(),
                                ))

                                // Process dialog
                                if (starsCount <= 3) {
                                    modelData.setReviewDialogState("TellUsEverything")
                                } else {
                                    modelData.reviewDialogWasCompleted("starRating")
                                    modelData.setReviewDialogState("ThankYou")
                                }
                            }
                    ) {
                        DynamicText(
                            text = "Next >",
                            modelData = modelData,
                            color = ColorPalette.getTextColor()
                        )
                    }
                }
            }


            if (dialogState == "WereSorryToHearThatWouldYouLikeToTellUsWhy") {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "We're sorry to hear that (",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    DynamicText(
                        text = "Would you like to tell us why?",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.reviewDialogWasCompleted("Later")
                                    modelData.setReviewDialogState("Closed")
                                }
                        ) {
                            DynamicText(
                                text = "Later",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }

                        Spacer(Modifier.width(16.dp))

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState("TellUsEverything")
                                }
                        ) {
                            DynamicText(
                                text = "Yes",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }
                    }

                    Spacer(Modifier.height(16.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState("DoYouEnjoyUsingThisApp")
                                }
                        ) {
                            DynamicText(
                                text = "< Back",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }

                        Spacer(Modifier.width(16.dp))

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState("PleaseTellUs")
                                }
                        ) {
                            DynamicText(
                                text = "No",
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }
                    }
                }
            }


            if (dialogState == "PleaseTellUs") {

                var pleaseCount by remember { mutableStateOf(1) }
                var text1 by remember { mutableStateOf("Please") }
                var text2 by remember { mutableStateOf("Tell Us what is going on...") }
                var yesButtonText by remember { mutableStateOf("Yes") }
                var isEnableNoButton by remember { mutableStateOf(true) }

                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = text1,
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(16.dp))

                    DynamicText(
                        text = text2,
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(16.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        if (isEnableNoButton) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(ColorPalette.getLightButtonColor())
                                    .weight(1F)
                                    .clickable {
                                        if (pleaseCount == 1) {
                                            text1 = "Please Please"
                                        }
                                        if (pleaseCount == 2) {
                                            text1 = "Please Please Please"
                                        }
                                        if (pleaseCount == 3) {
                                            text2 = "Don't prove I'm right..."
                                        }
                                        if (pleaseCount == 4) {
                                            yesButtonText = "Yas, Queen !!"
                                        }
                                        if (pleaseCount == 5) {
                                            isEnableNoButton = false
                                        }
                                        pleaseCount += 1
                                    }
                            ) {
                                DynamicText(
                                    text = "No",
                                    modelData = modelData,
                                    color = ColorPalette.getTextColor()
                                )
                            }

                            Spacer(Modifier.width(16.dp))
                        }

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(ColorPalette.getLightButtonColor())
                                .weight(1F)
                                .clickable {
                                    modelData.setReviewDialogState("TellUsEverything")
                                }
                        ) {
                            DynamicText(
                                text = yesButtonText,
                                modelData = modelData,
                                color = ColorPalette.getTextColor()
                            )
                        }
                    }
                }
            }


            if (dialogState == "TellUsEverything") {

                var textInput by remember { mutableStateOf("") }

                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "Tell us everything!!",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(16.dp))

                    TextField(
                        value = textInput,
                        onValueChange = { textInput = it },
                        placeholder = { Text("min 16 symbols") },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = ColorPalette.getTextColor(),
                            backgroundColor = ColorPalette.getBlockColor(),
                            cursorColor = ColorPalette.getTextColor(),
                            placeholderColor = ColorPalette.getTextColor()
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(ColorPalette.getLightButtonColor())
                    )

                    Spacer(Modifier.height(16.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(ColorPalette.getLightButtonColor())
                            .clickable {

                                if (textInput.length < 16) {
                                    modelData.setReviewDialogState("Min16Symbols")
                                } else {
                                    modelData.formSubmitted(mapOf(
                                        "formType" to "feedbackText",
                                        "textInput1" to  textInput
                                    ))
                                    modelData.reviewDialogWasCompleted("feedbackForm")
                                    modelData.setReviewDialogState("ThankYou")
                                }
                            }
                    ) {
                        DynamicText(
                            text = "Submit",
                            modelData = modelData,
                            color = ColorPalette.getTextColor()
                        )
                    }
                }
            }


            if (dialogState == "Min16Symbols") {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "Min 16 Symbols <3",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(ColorPalette.getLightButtonColor())
                            .clickable { modelData.setReviewDialogState("TellUsEverything") }
                    ) {
                        DynamicText(
                            text = "< back",
                            modelData = modelData,
                            color = ColorPalette.getTextColor()
                        )
                    }
                }
            }


            if (dialogState == "ThankYou") {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .wrapContentHeight()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(ColorPalette.getBlockColor())
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DynamicText(
                        text = "Thank You <3",
                        modelData = modelData,
                        style = MaterialTheme.typography.h6,
                        color = ColorPalette.getTextColor()
                    )

                    Spacer(Modifier.height(42.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(ColorPalette.getLightButtonColor())
                            .clickable {
                                modelData.setReviewDialogState("Closed")
                            }
                    ) {
                        DynamicText(
                            text = ")",
                            modelData = modelData,
                            color = ColorPalette.getTextColor()
                        )
                    }
                }
            }
        }
    }
}