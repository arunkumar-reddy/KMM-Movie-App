buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.android.tools.build:gradle:4.2.0")
    }
}

plugins {
    id("com.android.library") version ("4.2.0")
    kotlin("multiplatform") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.0"
    id("maven-publish")
}

group = "com.arun.moviedb.sdk"
version = "1.0.2-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName  = "1.0"
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(IR) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
    // val hostOs = System.getProperty("os.name")
    // val isMingwX64 = hostOs.startsWith("Windows")
    // val nativeTarget = when {
    //    hostOs == "Mac OS X" -> macosX64("native")
    //    hostOs == "Linux" -> linuxX64("native")
    //    isMingwX64 -> mingwX64("native")
    //    else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    // }


    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-cio:1.6.1")
            }
        }
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:1.6.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
                implementation("io.ktor:ktor-client-serialization:1.6.1")
                //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
            }
        }
        val commonTest by getting {
            dependencies {
                //implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                //implementation("io.ktor:ktor-client-js:1.6.1")
            }
        }
        val jsTest by getting
        // val nativeMain by getting
        // val nativeTest by getting
    }
}
