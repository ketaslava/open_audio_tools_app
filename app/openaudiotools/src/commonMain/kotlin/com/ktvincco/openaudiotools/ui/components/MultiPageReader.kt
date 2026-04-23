package com.ktvincco.openaudiotools.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
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
        val config = getReaderConfiguration()
        var currentReaderPageIndex by remember { mutableIntStateOf(0) }
        val readerPages = getReaderPages()
        val currentReaderPage = readerPages[currentReaderPageIndex]

        // Use key to recreate scrollState instantly when step changes, preventing flicker
        val scrollState = key(currentReaderPageIndex) { rememberScrollState() }

        // Get state values from modelData, then reset them, but save for use
        var previousPage by remember { mutableStateOf("") }
        val previousPageFromState = modelData.navigation.previousPage.collectAsState().value
        if (previousPageFromState.isNotEmpty()) {
            previousPage = previousPageFromState
            modelData.navigation.resetPreviousPage()
        }

        // Content wrapper
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorPalette.getBackgroundColor())
        ) {
            val isWideScreen = config.isEnableSquareBlockView && maxWidth > maxHeight
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .then(
                            if (isWideScreen) {
                                Modifier.aspectRatio(1F)
                            } else {
                                Modifier.fillMaxWidth()
                            }
                        )
                        .weight(1F)
                ) {
                    // Scrollable content
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        // Rendering content
                        currentReaderPage(modelData)
                    }
                }

                // Navigation
                val bc = ColorPalette.getBlockColor()
                val navigationBlockColor = Color(bc.red / 2F, bc.green / 2F, bc.blue / 2F)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .background(navigationBlockColor)
                ) {

                    // Back Button
                    val isFirstPage = currentReaderPageIndex == 0
                    val isBackButtonActive = !isFirstPage ||
                            config.isEnableBackButtonDestinationPage ||
                            (config.isAllowBackButtonByState && previousPage.isNotEmpty())

                    BasicComponents().Button(
                        modelData,
                        text = "< Back",
                        isAppearActive = isBackButtonActive,
                        cornerRadius = 0.dp,
                        inactiveButtonColor = navigationBlockColor,
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (currentReaderPageIndex > 0) {
                            currentReaderPageIndex--
                        } else {
                            if (config.isEnableBackButtonDestinationPage) {
                                modelData.openPage(config.backButtonDestinationPageName)
                            } else if (config.isAllowBackButtonByState && previousPage.isNotEmpty()) {
                                modelData.openPage(previousPage)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Page Counter
                    DynamicText(
                        text = "${currentReaderPageIndex + 1} / ${readerPages.size}",
                        modelData = modelData,
                        color = ColorPalette.getTextColor(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    // Next Button
                    val isLastPage = currentReaderPageIndex == readerPages.size - 1
                    val nextButtonIsActive = !isLastPage || config.isEnableNextButtonDestinationPage

                    BasicComponents().Button(
                        modelData,
                        text = "Next >",
                        isAppearActive = nextButtonIsActive,
                        cornerRadius = 0.dp,
                        inactiveButtonColor = navigationBlockColor,
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (currentReaderPageIndex < readerPages.size - 1) {
                            currentReaderPageIndex++
                        } else {
                            if (config.isEnableNextButtonDestinationPage) {
                                modelData.openPage(config.nextButtonDestinationPageName)
                            }
                        }
                    }
                }
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
        val isEnableNextButtonDestinationPage: Boolean = false,
        val nextButtonDestinationPageName: String = "",
    )


    open fun getReaderConfiguration(): ReaderConfiguration = ReaderConfiguration()
}
