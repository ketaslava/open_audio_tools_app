package com.ktvincco.openaudiotools.domain

import com.ktvincco.openaudiotools.data.AdvertisementService
import com.ktvincco.openaudiotools.presentation.ModelData


class AdvertisementManager (
    private val modelData: ModelData,
    private val advertisementService: AdvertisementService,
) {

    fun initialize() {

        // Assign callbacks
        assignCallbacks()

        // Initialize AD service
        advertisementService.initialize { result ->
            if (result) {
                modelData.setBannerAdBlock ({
                    advertisementService.BannerAdBlock()
                })
            }
        }
    }

    fun assignCallbacks() {
        modelData.assignOpenAdPrivacySettingsCallback {
            advertisementService.openAdPrivacySettings()
        }
    }

}