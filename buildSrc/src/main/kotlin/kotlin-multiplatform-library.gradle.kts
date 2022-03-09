@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android {
        publishLibraryVariants("release")
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Deps.KotlinX.coroutines)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(Deps.KotlinX.coroutinesTest)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.AndroidX.appcompat)
                implementation(Deps.AndroidX.coreKtx)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:${Versions.junit}")
            }
        }
        val desktopMain by getting {
            dependencies {

            }
        }
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test"))

            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}