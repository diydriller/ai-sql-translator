package com.github.diydriller.aisqltranslator.apis.openai.dto

data class OpenaiResponseDto(
    var choices: List<Choice>
){
    data class Choice(
        val message: ChoiceMessage
    )

    data class ChoiceMessage(
        val content: String
    )
}
