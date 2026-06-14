package com.ktvincco.openaudiotools

import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.ktvincco.openaudiotools.data.AndroidAdvertisementService
import com.ktvincco.openaudiotools.data.AndroidAudioPlayer
import com.ktvincco.openaudiotools.data.AndroidAudioRecorder
import com.ktvincco.openaudiotools.data.AndroidDatabase
import com.ktvincco.openaudiotools.data.AndroidEnvironmentConnector
import com.ktvincco.openaudiotools.data.AndroidLogger
import com.ktvincco.openaudiotools.data.AndroidPermissionController
import com.ktvincco.openaudiotools.data.AndroidSoundFile

class MainActivity : ComponentActivity() {

    // Create platform components
    private val androidLogger = AndroidLogger()
    private val permissionController = AndroidPermissionController(this)
    private val audioRecorder = AndroidAudioRecorder()
    private val androidDatabase = AndroidDatabase(this, AppInfo.NAME)
    private val androidSoundFile = AndroidSoundFile()
    private val androidAudioPlayer = AndroidAudioPlayer()
    private val environmentConnector = AndroidEnvironmentConnector(this)
    private val advertisementService = AndroidAdvertisementService(this)

    // On Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge UI layout
        enableEdgeToEdge()
        setDecorFitsSystemWindows(window, false)

        // Immersive mode
        // Android 11+
        window.insetsController?.let { controller ->
            // Hide status bar and navigation
            controller.hide(WindowInsets.Type.systemBars())
            // Set return by swipe behaviour
            controller.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        // Launch common app
        setContent {
            App(androidLogger, permissionController, audioRecorder, androidDatabase,
                androidSoundFile, androidAudioPlayer, environmentConnector, advertisementService)
        }

        // Process system "back" event
        onBackPressedDispatcher.addCallback(this) {
            // Do nothing
        }
    }

    // Permissions request callback
    @Deprecated("Deprecated in Java (Today don't have a Kotlin solution)")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        @Suppress("DEPRECATION")
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Process in domainController
        permissionController.requestPermissionsResultCallback(
            requestCode, permissions, grantResults)
    }
}
