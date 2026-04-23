package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktvincco.openaudiotools.ColorPalette
import com.ktvincco.openaudiotools.DynamicText
import com.ktvincco.openaudiotools.presentation.ModelData
import com.ktvincco.openaudiotools.ui.components.BasicComponents

open class MultiPageReader (
    val modelData: ModelData
) {

    @Composable
    fun Draw() {
        var currentReaderPageIndex by remember { mutableIntStateOf(0) }
        val readerPages = getReaderPages()
        val currentReaderPage = readerPages[currentReaderPageIndex]

        // Use key to recreate scrollState instantly when step changes, preventing flicker
        val scrollState = key(currentReaderPageIndex) { rememberScrollState() }

        // Scrollable Content
        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .background(ColorPalette.Companion.getBackgroundColor())
                .verticalScroll(scrollState)
        ) {
            // Step content
            currentReaderPage(modelData)

            // Navigation
            Column(
                horizontalAlignment = Alignment.Companion.CenterHorizontally,
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {

                // Page Counter
                DynamicText(
                    text = "${currentReaderPageIndex + 1} / ${readerPages.size}",
                    modelData = modelData,
                    color = ColorPalette.Companion.getTextColor(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Companion.Bold,
                    modifier = Modifier.Companion.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.Companion.height(16.dp))

                Row(
                    verticalAlignment = Alignment.Companion.CenterVertically,
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                ) {
                    // Back Button
                    BasicComponents().Button(
                        modelData,
                        text = "< Back",
                        isAppearActive = (currentReaderPageIndex > 0),
                        modifier = Modifier.Companion
                            .height(64.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    {
                        if (currentReaderPageIndex > 0) {
                            currentReaderPageIndex--
                        }
                    }

                    Spacer(modifier = Modifier.Companion.width(16.dp))

                    // Next Button
                    BasicComponents().Button(
                        modelData,
                        text = "Next >",
                        isAppearActive = (currentReaderPageIndex < readerPages.size - 1),
                        modifier = Modifier.Companion
                            .height(64.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    {
                        if (currentReaderPageIndex < readerPages.size - 1) {
                            currentReaderPageIndex++
                        }
                    }
                }

                Spacer(modifier = Modifier.Companion.height(24.dp))
            }
        }
    }


    open fun getReaderPages(): List<@Composable (ModelData) -> Unit> = listOf()


    class ReaderConfiguration(

        // View
        val isEnableSquareBlockView: Boolean = true,

        // Borderline buttons
        // Fixed value is always overrides the value from the state
        val isEnableBackButtonDestinationPage: Boolean = false,
        val backButtonDestinationPageName: String = "",
        val isAllowBackButtonByState: Boolean = false,
        val isEnableFinishButtonDestinationPage: Boolean = false,
        val finishButtonDestinationPageName: String = "",
    )


    open fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration()
}