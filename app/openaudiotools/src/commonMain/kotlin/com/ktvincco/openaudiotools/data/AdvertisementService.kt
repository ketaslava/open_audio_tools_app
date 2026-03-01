package com.ktvincco.openaudiotools.data

import androidx.compose.runtime.Composable

interface AdvertisementService {

    fun initialize(initializationCallback: (result: Boolean) -> Unit)
    @Composable
    fun BannerAdBlock()
    fun showScreenAd()
    fun showScreenBlockingAd(resultCallback: (result: Boolean) -> Unit)
    @Composable
    fun NativeAdBlock()
    fun initializeOnSwitchAd()
    fun openAdPrivacySettings()

}