object Versions{

    val kotlin="1.6.0"
    val gradle="7.0.3"
    val core_ktx="1.7.0"
    val appcompat="1.4.1"
    val material="1.5.0"
    val constraintlayout="2.1.3"
    val junit="4.+"
    val hilt="2.28-alpha"

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
}

object VersionConfig{
    val minSdk=21
    val compileSdk=32
    val targetSdk=32
    val versionCode=1
    val versionName="1.0"
}