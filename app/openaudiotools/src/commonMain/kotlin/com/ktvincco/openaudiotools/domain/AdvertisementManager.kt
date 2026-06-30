package com.ktvincco.openaudiotools.domain

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ktvincco.openaudiotools.Configuration
import com.ktvincco.openaudiotools.data.AdvertisementService
import com.ktvincco.openaudiotools.data.Database
import com.ktvincco.openaudiotools.presentation.ModelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.ceil


class AdvertisementManager (
    private val modelData: ModelData,
    private val advertisementService: AdvertisementService,
    private val database: Database,
) {

    private val adFreeTimePerAdMs = 24L * 60L * 60L * 1000L // 24 hours
    private val maxDisplayDays = 8

    fun initialize() {

        // Assign callbacks
        assignCallbacks()

        // Initialize AD service
        advertisementService.initialize { result ->
            if (result) {
                modelData.setBannerAdBlock {
                    val isAdsActive by modelData.isAdsActive.collectAsState()
                    if (isAdsActive) {
                        advertisementService.BannerAdBlock()
                    }
                }
            }
        }

        // Periodic battery update
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                updateBatteryState()
                delay(1000 * 30) // Periodic updates
            }
        }
    }

    fun assignCallbacks() {
        modelData.assignOpenAdPrivacySettingsCallback {
            advertisementService.openAdPrivacySettings()
        }

        modelData.assignWatchScreenBlockingAdCallback {
            if (modelData.isAdLoading.value) return@assignWatchScreenBlockingAdCallback

            if (Configuration.IS_ENABLE_ADS) {
                modelData.setIsAdLoading(true)
                advertisementService.showScreenBlockingAd { result ->
                    modelData.setIsAdLoading(false)
                    if (result) {
                        rewardUser()
                    }
                }
            } else {
                // For desktop/disabled ads - just reward
                rewardUser()
            }
        }
    }

    private fun rewardUser() {
        val currentTime = getCurrentUnixTimeMs()
        val currentExpiration = getExpirationTime()
        val newExpiration = if (currentExpiration > currentTime) {
            currentExpiration + adFreeTimePerAdMs
        } else {
            currentTime + adFreeTimePerAdMs
        }
        database.saveString("appBatteryExpirationTime", newExpiration.toString())
        updateBatteryState()
    }

    private fun updateBatteryState() {
        val currentTime = getCurrentUnixTimeMs()
        val expirationTime = getExpirationTime()
        val remainingMs = expirationTime - currentTime

        // Update Ads active status in model data for instant UI reaction
        modelData.setIsAdsActive(remainingMs <= 0L)

        if (remainingMs > 0L) {

            val remainingDays = ceil(remainingMs.toDouble() / adFreeTimePerAdMs).toInt()
            modelData.setAppBatteryTimeText(remainingDays.toString())
            val chargeFraction = remainingMs.toFloat() / (maxDisplayDays * adFreeTimePerAdMs)
            modelData.setAppBatteryCharge(chargeFraction.coerceIn(0f, 1f))

        } else {

            modelData.setAppBatteryTimeText("0")
            modelData.setAppBatteryCharge(0f)
        }
    }


    private fun getExpirationTime(): Long {
        val timeStr = database.loadString("appBatteryExpirationTime") ?: "0"
        return timeStr.toLongOrNull() ?: 0L
    }

    private fun getCurrentUnixTimeMs(): Long {
        return System.currentTimeMillis()
    }
}
