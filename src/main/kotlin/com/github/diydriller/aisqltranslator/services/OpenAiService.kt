package com.github.diydriller.aisqltranslator.services

import com.github.diydriller.aisqltranslator.apis.openai.api.OpenaiApi
import com.github.diydriller.aisqltranslator.apis.openai.dto.OpenaiRequestDto
import com.github.diydriller.aisqltranslator.prompt.TranslateSql
import com.github.diydriller.aisqltranslator.util.StringUtil

class OpenAiService(
    private val openaiApi: OpenaiApi = OpenaiApi.create()
) {
    fun translateSql(fromSql: String, toSql: String, query: String): String {
        val systemMessage = OpenaiRequestDto.Message(
            role = "system",
            content = TranslateSql.getSystemMessage(fromSql, toSql)
        )
        val userMessage = OpenaiRequestDto.Message(
            role = "user",
            content = TranslateSql.getUserMessage(query)
        )
        val response = openaiApi.chat(
            OpenaiRequestDto(messages = listOf(systemMessage, userMessage))
        ).execute().body()

        val output = response?.choices?.first()?.message?.content
        return StringUtil.extractSqlFromCode(output!!)
    }
}