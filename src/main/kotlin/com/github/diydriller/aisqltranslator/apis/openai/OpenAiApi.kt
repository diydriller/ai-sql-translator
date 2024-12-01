package com.github.diydriller.aisqltranslator.apis.openai

import com.github.diydriller.aisqltranslator.dto.request.TranslateRequestDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

fun interface OpenAiApi {
    @POST("v1/completions")
    fun translateSql(@Body request: TranslateRequestDto): Call<String>

    companion object {
        fun create(): OpenAiApi =
            OpenAiApiClient
                .getClient()
                .create(OpenAiApi::class.java)
    }
}