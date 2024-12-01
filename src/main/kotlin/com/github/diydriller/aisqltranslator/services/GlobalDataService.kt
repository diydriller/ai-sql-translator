package com.github.diydriller.aisqltranslator.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service

@Service
class GlobalDataService {
    var aiApiKey: String? = null
    var selectedFromSql: String? = null
    var selectedToSql: String? = null

    companion object {
        fun getInstance(): GlobalDataService = service()
    }
}