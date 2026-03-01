package com.ktvincco.openaudiotools.data

class WasmAdvertisementService: AdvertisementService {

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
        TODO("Not yet implemented")
    }

}