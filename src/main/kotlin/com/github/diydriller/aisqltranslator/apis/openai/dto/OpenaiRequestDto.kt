package com.github.diydriller.aisqltranslator.apis.openai.dto

data class OpenaiRequestDto(
    val model: String = "gpt-4o-mini",
    val messages: List<Message>
){
    data class Message(
        val role: String,
        val content: String
    )
}