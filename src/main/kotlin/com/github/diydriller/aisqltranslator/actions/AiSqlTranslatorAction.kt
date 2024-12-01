package com.github.diydriller.aisqltranslator.actions

import com.github.diydriller.aisqltranslator.dialogs.AiSqlTranslatorDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class AiSqlTranslatorAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val dialog = AiSqlTranslatorDialog()
        dialog.show()
    }
}