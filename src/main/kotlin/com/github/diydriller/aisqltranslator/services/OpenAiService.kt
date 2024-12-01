package com.github.diydriller.aisqltranslator.services

import com.github.diydriller.aisqltranslator.apis.openai.OpenAiApi
import com.github.diydriller.aisqltranslator.dto.request.TranslateRequestDto
import retrofit2.Response

class OpenAiService(
    private val openAiApi: OpenAiApi = OpenAiApi.create()
) {
    fun translateSql(fromSql: String, toSql: String, query: String): Response<String> =
        TranslateRequestDto.of(fromSql, toSql, query).let { openAiApi.translateSql(it).execute() }
}