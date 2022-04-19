object Versions{

    val kotlin="1.4.30"
    val gradle="7.0.3"
    val core_ktx="1.7.0"
    val appcompat="1.4.1"
    val material="1.5.0"
    val constraintlayout="2.1.3"
    val junit="4.+"
    val junittestimple="1.1.3"
    val espresso="3.4.0"
    val hilt="2.28-alpha"
    val hilttest="2.33-beta"
    val viewModelLifeCycle="2.2.0"
    val coroutines="1.4.2"
    val ActivityKTX="1.1.0"
    val hiltRule="1.4.0-alpha05"
    val hiltViewModel="1.0.0-alpha01"
    val retrofit="2.6.0"
    val interceptor="4.5.0"
    val glide="4.12.0"
    val leakcanary="2.7"
    val truth="1.0.1"
    val room="2.3.0"
    val paging="3.1.1"
    val navigation="2.3.5"


}
object Deps{
    val gradle="com.android.tools.build:gradle:${Versions.gradle}"
    val plugin="org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val core_ktx="androidx.core:core-ktx:${Versions.core_ktx}"
    val hilt="com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    val appcompat="androidx.appcompat:appcompat:${Versions.appcompat}"
    val material="com.google.android.material:material:${Versions.material}"
    val constraintlayout="androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    val junit="junit:junit:${Versions.junit}"
    val junittestimple="androidx.test.ext:junit:${Versions.junittestimple}"
    val espresso="androidx.test.espresso:espresso-core:${Versions.espresso}"
    val viewModelLifeCycle="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelLifeCycle}"
    val viewModelLifeCycleRuntime="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewModelLifeCycle}"
    val ActivityKTX= "androidx.activity:activity-ktx:${Versions.ActivityKTX}"
    val coroutinesCore="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesRuntime="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val hiltAndroid="com.google.dagger:hilt-android:${Versions.hilt}"
    val hilttest="com.google.dagger:hilt-android-testing:${Versions.hilttest}"
    val hilttestCompiler="com.google.dagger:hilt-android-compiler:${Versions.hilttest}"
    val hiltRule="androidx.test:rules:${Versions.hiltRule}"
    val hiltCompiler="com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hiltViewModel="androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    val hiltkapt="androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"
    val retrofit="com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val converter_gson="com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val interceptor="com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    val glide="com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler="com.github.bumptech.glide:compiler:${Versions.glide}"
    val leakcanary="com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    val truth="com.google.truth:truth:${Versions.truth}"

    val room="androidx.room:room-runtime:${Versions.room}"
    val room_compiler="androidx.room:room-compiler:${Versions.room}"
    val paging="androidx.paging:paging-runtime-ktx:${Versions.paging}"
    val navigation="androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUI="androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

}

object VersionConfig{
    val minSdk=21
    val compileSdk=32
    val targetSdk=32
    val versionCode=1
    val versionName="1.0"
}