plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.attendancesystemandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.attendancesystemandroid"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding{
        enable = true
    }
}

dependencies {

    implementation("com.github.AAChartModel:AAChartCore-Kotlin:-SNAPSHOT")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("io.github.scwang90:refresh-layout-kernel:2.1.0")      //核心必须依赖
    implementation("io.github.scwang90:refresh-header-classics:2.1.0")    //经典刷新头
    implementation("io.github.scwang90:refresh-header-radar:2.1.0")       //雷达刷新头
    implementation("io.github.scwang90:refresh-header-falsify:2.1.0")     //虚拟刷新头
    implementation("io.github.scwang90:refresh-header-material:2.1.0")    //谷歌刷新头
    implementation("io.github.scwang90:refresh-header-two-level:2.1.0")  //二级刷新头
    implementation("io.github.scwang90:refresh-footer-ball:2.1.0")        //球脉冲加载
    implementation("io.github.scwang90:refresh-footer-classics:2.1.0")    //经典加载
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}