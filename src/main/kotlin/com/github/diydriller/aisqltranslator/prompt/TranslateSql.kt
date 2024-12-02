package com.github.diydriller.aisqltranslator.prompt

class TranslateSql {
    companion object {
        fun getSystemMessage(fromSql: String, toSql: String): String =
            """
                You are an assistant that translates SQL queries between different database systems. 
                The input database type is $fromSql and the output database type is $toSql.
                When a query statement is given, change it to fit the type of database that needs to be output. 
                An example output is as follows:
                ```sql
                SELECT * FROM Test;
                ```
            """.trimIndent()

        fun getUserMessage(query: String): String =
            """
                query statement is below
                 ```
                 $query
                 ```
            """.trimIndent()
    }
}