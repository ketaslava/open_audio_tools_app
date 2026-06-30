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
import android.util.Log
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
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

    private val TAG = "AdMobService"

    // Configuration
    val admobBannerAdId = "ca-app-pub-2048316563269126/2764483453"
    val admobScreenBlockingAdId = "ca-app-pub-2048316563269126/8439529690"


    private val consentInformation by lazy {
        UserMessagingPlatform.getConsentInformation(activity)
    }

    private var adsInitialized = false

    override fun initialize(initializationCallback: (result: Boolean) -> Unit) {

        // Check AD switch
        if (!Configuration.IS_ENABLE_ADS) {
            Log.d(TAG, "Ads are disabled in Configuration")
            initializationCallback(false)
            return
        }

        // Open privacy consent popup or skip if not required
        activity.runOnUiThread {
            val params = ConsentRequestParameters.Builder().build()

            Log.d(TAG, "Requesting consent info update...")
            consentInformation.requestConsentInfoUpdate(
                activity,
                params,
                {
                    // Consent info updated successfully
                    Log.d(TAG, "Consent info updated. Loading and showing form if required...")
                    UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                        activity
                    ) { formError ->
                        if (formError != null) {
                            Log.e(TAG, "Consent form error: ${formError.message}")
                        }
                        // After form dismissed (or not required)
                        if (consentInformation.canRequestAds()) {
                            Log.d(TAG, "Can request ads now. Initializing MobileAds...")
                            initializeMobileAds(initializationCallback)
                        } else {
                            Log.w(TAG, "Cannot request ads yet.")
                            initializationCallback(false)
                        }
                    }
                },
                { error ->
                    Log.e(TAG, "Consent update error: ${error.message}")
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

        MobileAds.initialize(activity) { status ->
            Log.d(TAG, "MobileAds initialized: $status")
            adsInitialized = true
            callback(true)
        }
    }

    @Deprecated("AdSize is not not implemented to Kotlin yet")
    @Suppress("DEPRECATION")
    @Composable
    override fun BannerAdBlock() {
        // Check if we can request ads based on CMP status
        if (!consentInformation.canRequestAds()) {
            Log.w(TAG, "BannerAdBlock: cannot request ads based on CMP status")
            return
        }

        val context = LocalContext.current
        val configuration = LocalConfiguration.current

        // State to track if the ad has successfully loaded
        val isAdLoaded = remember { mutableStateOf(false) }

        // 1. Get width from LocalConfiguration (more reliable for full-width)
        val screenWidthDp = configuration.screenWidthDp

        // 2. Calculate the standard adaptive ad size
        val adSize = remember(screenWidthDp) {
            AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, screenWidthDp)
        }

        // 3. Select ID
        val adUnitIdStr = if (Configuration.IS_ENABLE_ADS_IN_TEST_MODE) {
            "ca-app-pub-3940256099942544/9214589741"
        } else { admobBannerAdId }

        // 4. Create AdView and attach a Listener
        val adView = remember(adSize) {
            Log.d(TAG, "Creating AdView with unitId: $adUnitIdStr and size: $adSize")
            AdView(activity).apply {
                adUnitId = adUnitIdStr
                setAdSize(adSize)
                adListener = object : com.google.android.gms.ads.AdListener() {
                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        Log.d(TAG, "Ad loaded successfully")
                        isAdLoaded.value = true // Show the UI when loaded
                    }
                    override fun onAdFailedToLoad(error: com.google.android.gms.ads.LoadAdError) {
                        super.onAdFailedToLoad(error)
                        Log.e(TAG, "Ad failed to load: ${error.message}, code: ${error.code}")
                    }
                }
                loadAd(AdRequest.Builder().build())
            }
        }

        DisposableEffect(adView) {
            onDispose {
                Log.d(TAG, "Destroying AdView")
                adView.destroy()
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
        if (!adsInitialized) {
            Log.w(TAG, "showScreenBlockingAd: MobileAds not initialized")
            resultCallback(false)
            return
        }

        val adUnitIdStr = if (Configuration.IS_ENABLE_ADS_IN_TEST_MODE) {
            "ca-app-pub-3940256099942544/5224354917"
        } else { admobScreenBlockingAdId }

        if (adUnitIdStr.isEmpty()) {
            Log.w(TAG, "showScreenBlockingAd: adUnitId is empty")
            resultCallback(false)
            return
        }

        activity.runOnUiThread {
            com.google.android.gms.ads.rewarded.RewardedAd.load(
                activity,
                adUnitIdStr,
                AdRequest.Builder().build(),
                object : com.google.android.gms.ads.rewarded.RewardedAdLoadCallback() {
                    override fun onAdLoaded(rewardedAd: com.google.android.gms.ads.rewarded.RewardedAd) {
                        Log.d(TAG, "Screen blocking ad loaded")
                        rewardedAd.show(activity) { rewardItem ->
                            Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type}")
                            resultCallback(true)
                        }
                    }

                    override fun onAdFailedToLoad(error: com.google.android.gms.ads.LoadAdError) {
                        Log.e(TAG, "Screen blocking ad failed to load: ${error.message}")
                        resultCallback(false)
                    }
                }
            )
        }
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