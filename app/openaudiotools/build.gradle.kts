import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

// Settings
val appName = "OpenAudioTools"

// Configs
val version = "2.5.0" // == CHANGE BEFORE RELEASE (1/7) //
val androidVersionCode = 21 // == CHANGE BEFORE RELEASE (2/7) //

// Auto update app version in configs
val generateAppInfo by tasks.registering {
    doLast {
        val dir = project.file("src/commonMain/kotlin/com/ktvincco/openaudiotools")
        dir.mkdirs()
        val file = dir.resolve("AppInfo.kt")
        file.writeText("""
            package com.ktvincco.openaudiotools
            
            object AppInfo {
                const val NAME = "$appName"
                const val VERSION = "$version"
            }
        """.trimIndent() + "\n")
    }
}

// Ensure the task runs before compilation
tasks.matching { it.name.contains("compile") }.configureEach {
    dependsOn(generateAppInfo)
}

kotlin {

    android {
        namespace = "com.ktvincco.openaudiotools"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.runtime)
                implementation(libs.foundation)
                implementation(libs.material)
                implementation(libs.ui)
                implementation(libs.components.resources)
                implementation(libs.ui.tooling.preview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.lifecycle.process)
                implementation(libs.play.services.ads)
                
                // Moved from top-level
                implementation(libs.androidx.foundation.layout.android)
                implementation(libs.androidx.foundation.android)
                implementation(libs.androidx.material3.android)
                implementation(libs.androidx.ui.android)
                implementation(libs.androidx.compose.material)
                implementation(libs.androidx.runtime.android)
                implementation(libs.androidx.ui.geometry.android)
                implementation(libs.androidx.ui.unit.android)
                implementation(libs.androidx.ui.text.android)
                implementation(libs.androidx.activity.ktx)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
            }
        }
    }
}

compose.resources {
    packageOfResClass = "com.ktvincco.openaudiotools"
}

compose.desktop {
    application {
        mainClass = "com.ktvincco.openaudiotools.MainKt"

        val jvmArgsList = listOf(
            "-XX:+UseG1GC", // "", -XX:+UseG1GC , -XX:+UseZGC // -XX:+UseG1GC
            "-XX:G1PeriodicGCInterval=2000", // 2000
        )

        jvmArgs.addAll(jvmArgsList)

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi,
                TargetFormat.Deb, TargetFormat.Rpm, TargetFormat.AppImage)
            packageName = appName
            packageVersion = version
            jvmArgs.addAll(jvmArgsList)
            modules.addAll(arrayListOf("java.base", "java.net.http"))
            linux {
                iconFile.set(project.file("src/commonMain/composeResources/drawable/icon.png"))
            }
        }
    }
}
