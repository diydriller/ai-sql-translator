package com.github.diydriller.aisqltranslator.util

class StringUtil {
    companion object {
        fun extractSqlFromCode(content: String): String {
            val regex = Regex("""(?s)```sql(.*?)```""")
            val matchResult = regex.find(content)
            return matchResult?.groupValues?.get(1)?.trim() ?: ""
        }
    }
}