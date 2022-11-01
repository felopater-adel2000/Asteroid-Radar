# Asteroid Radar

project 1 for [Advanced Android Nanodegree egfwd, Udacity](https://egfwd.com/specializtion/android-kotlin/)

consist of five screens

1. Main Screen: Displays all asteroids close to Earth from today and for the next week
2. Details Screen: Displays more details about selected Asteroid

## Tools and Dependencies

* Room Database
* Retrofit 
* Navigation Component
* Recyclerview
* WorkManager
* Offline Caching
* Glide
* MVVM

```
implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.2.0-alpha04'

    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
    implementation 'androidx.fragment:fragment-ktx:1.5.4'


    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    implementation "com.squareup.moshi:moshi:1.14.0"
    implementation "com.squareup.moshi:moshi-kotlin:1.14.0"

    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-moshi:2.9.0"
    implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'

    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"

    implementation "androidx.recyclerview:recyclerview:1.2.1"

    implementation 'com.squareup.picasso:picasso:2.5.2'

    implementation("androidx.room:room-ktx:2.5.0-beta01")
    implementation "androidx.room:room-runtime:2.5.0-beta01"
    kapt "androidx.room:room-compiler:2.5.0-beta01"

    implementation "android.arch.work:work-runtime-ktx:1.0.1"

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    implementation "com.github.bumptech.glide:glide:4.8.0"
```

## Screenshots

![MainScreen](screenshots/screen_1.png)

![DetailsScreen](screenshots/screen_2.png)

![DetailsScreen](screenshots/screen_3.png)

![DetailsScreen](screenshots/screen_4.png)