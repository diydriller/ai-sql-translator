package com.github.diydriller.aisqltranslator.apis.openai.api

import com.github.diydriller.aisqltranslator.apis.openai.dto.OpenaiRequestDto
import com.github.diydriller.aisqltranslator.apis.openai.dto.OpenaiResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

fun interface OpenaiApi {
    @POST("/v1/chat/completions")
    fun chat(@Body request: OpenaiRequestDto): Call<OpenaiResponseDto>

    companion object {
        fun create(): OpenaiApi =
            OpenaiApiClient.getClient()
                .create(OpenaiApi::class.java)
    }
}