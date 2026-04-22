package com.ktvincco.openaudiotools.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.basics.BaseComponents
import openaudiotools.app.openaudiotools.generated.resources.Res
import openaudiotools.app.openaudiotools.generated.resources.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import openaudiotools.app.openaudiotools.generated.resources.arrow_forward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

data class FAQItem(
    val question: String,
    val answer: String
)

class FrequentlyAskedQuestions(
    private val modelData: ModelData
) {

    private val faqList = listOf(
        FAQItem(
            question = "How can I speak to a manager?",
            answer = "You can always find the developer's contacts on the Dashboard. Talk to us freely, we will always try to reply to you. Maybe, we are not even that busy as you might think... (I hope)"
        ),
        FAQItem(
            question = "Where are the recordings saved on my device?",
            answer = "== Desktop ==\n" +
                    "Your recordings are stored in:\n" +
                    "~/OpenAudioTools\n" +
                    "(\"~\" stands for User's Home Directory)\n\n" +
                    "== Android ==\n" +
                    "Your recordings are stored in:\n" +
                    "#/storage/emulated/0/Music/OpenAudioTools\n" +
                    "Or, if you using just a regular file explorer, it's gonna be just:\n" +
                    "~$/Music/OpenAudioTools"
        ),
        // Add more questions here easily
    )

    @Composable
    fun Draw() {
        val scrollState = rememberScrollState()

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(ColorPalette.getBackgroundColor())
                .padding(horizontal = 16.dp)
                .verticalScroll(state = scrollState)
        ) {
            DynamicText(
                text = "Frequently Asked Questions",
                modelData = modelData,
                color = ColorPalette.getTextColor(),
                fontSize = 28.sp,
                lineHeight = 36.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            )

            BaseComponents().HorizontalDivider(
                color = ColorPalette.getMarkupColor(), thickness = 1.dp
            )

            faqList.forEach { faq ->
                FAQCard(faq)
                BaseComponents().HorizontalDivider(
                    color = ColorPalette.getMarkupColor(), thickness = 1.dp
                )
            }

            Spacer(modifier = Modifier.height(64.dp))
        }
    }

    @Composable
    private fun FAQCard(faq: FAQItem) {
        var isExpanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded }
                .padding(vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DynamicText(
                    text = faq.question,
                    modelData = modelData,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = ColorPalette.getTextColor(),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                )

                val arrowIcon = if (isExpanded) Res.drawable.arrow_downward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
                    else Res.drawable.arrow_forward_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(arrowIcon),
                        null,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    DynamicText(
                        text = faq.answer,
                        modelData = modelData,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = ColorPalette.getTextColor()
                    )
                }
            }
        }
    }
}
