package com.ktvincco.openaudiotools.data

import androidx.compose.runtime.Composable

class DesktopAdvertisementService: AdvertisementService {

    override fun initialize(initializationCallback: (Boolean) -> Unit) {
        initializationCallback(false) // Not implemented
    }

    @Composable
    override fun BannerAdBlock() {
        TODO("Not yet implemented")
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

    }

}