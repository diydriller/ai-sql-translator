package com.github.diydriller.aisqltranslator.apis.openai.api

import com.github.diydriller.aisqltranslator.services.GlobalDataService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenaiApiClient {

    private const val BASE_URL = "https://api.openai.com/"

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .client(getOkHttpClient())
            .build()

    private fun getOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(openAiApiInterceptor)
            .build()

    private val openAiApiInterceptor = Interceptor { chain ->
        chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer ${GlobalDataService.getInstance().aiApiKey}")
                .build()
        )
    }

    private fun getGson(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
}