package com.ktvincco.openaudiotools.data


interface EnvironmentConnector {
    fun openAppPermissionSettings()
    fun sendPOSTRequest(url: String, payload: String,
                        onResult: (success: Boolean, response: String?) -> Unit)
    fun getUserInfo(): Map<String, String>
    fun openWebLink(url: String)
    fun restartTheApplication()
    fun getYYYYMMDDHHMMSSString(): String
    fun getDefaultLanguageCode(): String
    fun addOnAppPausedCallback(callback: () -> Unit)
    fun addOnAppResumedCallback(callback: () -> Unit)
    fun promptUserToMakeAStoreReview()
    fun forceGC()
}