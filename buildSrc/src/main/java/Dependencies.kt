/*
 * Copyright 2021 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Versions {
    const val activityKtx = "1.3.0-alpha02"
    const val appCompat = "1.2.0"
    const val androidGradlePlugin = "7.0.0-alpha06"
    const val compose = "1.0.0-alpha12"
    const val daggerHilt = "2.31.2-alpha"
    const val espressoCore = "3.3.0"
    const val extJunit = "1.1.2"
    const val junit = "4.13.1"
    const val junitKtx = "1.1.2"
    const val kotlin = "1.4.30"
    const val ktLint = "0.40.0"
    const val ktxVersion = "1.3.2"
    const val lifecycle = "2.2.0"
    const val materialComponents = "1.3.0-rc01"
    const val navigationCompose = "1.0.0-alpha07"
    const val robolectric = "4.3.1"
    const val roomKtx = "2.2.6"
    const val testCoreKtx = "1.3.0"
    const val timber = "4.7.1"
}

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"

    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val junit = "junit:junit:${Versions.junit}"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktxVersion}"
        const val junitKtx = "androidx.test.ext:junit-ktx:${Versions.junitKtx}"
        const val testCoreKtx = "androidx.test:core-ktx:${Versions.testCoreKtx}"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:${Versions.activityKtx}"
            const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
        }

        object Compose {
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
        }

        object Lifecycle {
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
        }

        object Room {
            const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
            const val roomRuntime = "androidx.room:room-runtime:${Versions.roomKtx}"
            const val roomCompiler = "androidx.room:room-compiler:${Versions.roomKtx}"
            const val roomTesting = "androidx.room:room-testing:${Versions.roomKtx}"
        }

        object Test {
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
            const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        }
    }

    object Google {

        object Dagger {
            const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
            const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
            const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
            const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
        }

        object Material {
            const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
        }
    }
}
