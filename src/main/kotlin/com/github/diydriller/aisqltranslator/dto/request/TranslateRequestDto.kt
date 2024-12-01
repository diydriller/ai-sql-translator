package com.github.diydriller.aisqltranslator.dto.request

data class TranslateRequestDto(
    val prompt: String
) {
    companion object {
        fun of(fromSql: String, toSql: String, query: String): TranslateRequestDto =
            TranslateRequestDto(prompt = makePrompt(fromSql, toSql, query))

        private fun makePrompt(fromSql: String, toSql: String, query: String): String =
            """
                Your role is to convert between SQL. 
                Given the type of SQL that is input and the type of SQL that should be output,and given a SQL query, 
                you need to convert it into the type of SQL that should be output.
                The type of SQL input is $fromSql and the query is below.
                ```
                $query
                ```
                $toSql is the type of SQL that is output, and it returns the converted query statement.           
            """.trimIndent()
    }
}