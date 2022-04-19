package com.example.elmenus.domain.di

import com.example.elmenus.BuildConfig
import com.example.elmenus.data.remote.webservice.WebService
import com.example.elmenus.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    const val CONNECTION_TIME_OUT_TIME = 60L

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        if (BuildConfig.DEBUG) {
        val loggingInterceptor =
            HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(CONNECTION_TIME_OUT_TIME, TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIME_OUT_TIME, TimeUnit.SECONDS)
            .callTimeout(CONNECTION_TIME_OUT_TIME, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIME_OUT_TIME, TimeUnit.SECONDS)
            .build()
        } else {
            return OkHttpClient
                .Builder()
                .build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(WebService::class.java)


}