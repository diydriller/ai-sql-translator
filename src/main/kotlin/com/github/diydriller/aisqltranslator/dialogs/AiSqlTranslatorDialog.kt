package com.github.diydriller.aisqltranslator.dialogs

import com.github.diydriller.aisqltranslator.tabs.SettingTab
import com.github.diydriller.aisqltranslator.tabs.TranslateTab
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.*

class AiSqlTranslatorDialog : DialogWrapper(true) {

    init {
        title = "AI SQL Translator"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val tabbedPane = JTabbedPane()

        val settingTab = SettingTab()
        tabbedPane.add("Setting", settingTab)

        val translateTab = TranslateTab()
        tabbedPane.addTab("Translate", translateTab)

        return tabbedPane
    }

    override fun doOKAction() {
        super.doOKAction()
    }
}