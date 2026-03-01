package com.ktvincco.openaudiotools.data

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.ump.UserMessagingPlatform
import com.ktvincco.openaudiotools.data.advertisement.BannerAd
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.core.net.toUri
import androidx.core.view.isNotEmpty
import com.google.android.ump.ConsentRequestParameters
import com.ktvincco.openaudiotools.Configuration


class AndroidAdvertisementService (private val activity: Activity): AdvertisementService {

    private val consentInformation by lazy {
        UserMessagingPlatform.getConsentInformation(activity)
    }

    private var adsInitialized = false

    override fun initialize(initializationCallback: (result: Boolean) -> Unit) {

        // Check AD switch
        /*if (!Configuration.IS_ENABLE_ADS) {
            initializationCallback(false)
            return
        }*/

        // Open privacy consent popup or skip if not required
        activity.runOnUiThread {
            val params = ConsentRequestParameters.Builder().build()

            consentInformation.requestConsentInfoUpdate(
                activity,
                params,
                {
                    // Consent info updated successfully
                    UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                        activity
                    ) { formError ->
                        // After form dismissed (or not required)
                        if (consentInformation.canRequestAds()) {
                            initializeMobileAds(initializationCallback)
                        } else {
                            initializationCallback(false)
                        }
                    }
                },
                { error ->
                    initializationCallback(false)
                }
            )
        }
    }

    private fun initializeMobileAds(callback: (Boolean) -> Unit) {
        if (adsInitialized) {
            callback(true)
            return
        }

        MobileAds.initialize(activity) {
            adsInitialized = true
            callback(true)
        }
    }

    @Deprecated("AdSize is not not implemented to Kotlin yet")
    @Suppress("DEPRECATION")
    @Composable
    override fun BannerAdBlock() {
        // Check if we can request ads based on CMP status
        if (!consentInformation.canRequestAds()) return

        val context = LocalContext.current
        val density = LocalDensity.current
        val windowInfo = LocalWindowInfo.current

        // State to track if the ad has successfully loaded
        val isAdLoaded = remember { mutableStateOf(false) }

        // 1. Get width from LocalWindowInfo and convert to DP
        val screenWidthDp = remember(windowInfo.containerSize, density) {
            with(density) { windowInfo.containerSize.width.toDp().value.toInt() }
        }

        // 2. Calculate the standard adaptive ad size
        val adSize = remember(screenWidthDp) {
            AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, screenWidthDp)
        }

        // 3. Select ID
        val adUnitIdStr = if (Configuration.IS_ENABLE_ADS_IN_TEST_MODE) {
            "ca-app-pub-3940256099942544/9214589741"
        } else {
            "ca-app-pub-3343103877905532/3608260139"
        }

        // 4. Create AdView and attach a Listener
        val adView = remember(adSize) {
            AdView(activity).apply {
                adUnitId = adUnitIdStr
                setAdSize(adSize)
                adListener = object : com.google.android.gms.ads.AdListener() {
                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        isAdLoaded.value = true // Show the UI when loaded
                    }
                }
                loadAd(AdRequest.Builder().build())
            }
        }

        // 5. Only show the container if the ad is loaded
        if (isAdLoaded.value) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(adSize.height.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BannerAd(adView, Modifier)
            }
        }
    }

    override fun showScreenAd() {
        TODO("Not yet implemented")
    }

    override fun showScreenBlockingAd(resultCallback: (Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun NativeAdBlock() {
        TODO("Not yet implemented")
    }

    override fun initializeOnSwitchAd() {
        TODO("Not yet implemented")
    }

    override fun openAdPrivacySettings() {
        activity.runOnUiThread {
            try {
                UserMessagingPlatform.showPrivacyOptionsForm(activity) { formError ->
                    if (formError != null) {
                        openAdPrivacySettingsWebPage()
                    }
                }
            } catch (e: Exception) {
                openAdPrivacySettingsWebPage()
            }
        }
    }

    fun openAdPrivacySettingsWebPage() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            "https://adssettings.google.com/".toUri()
        )
        activity.startActivity(intent)
    }
}