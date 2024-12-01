package com.github.diydriller.aisqltranslator.dialogs

import com.github.diydriller.aisqltranslator.tabs.SettingTab
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


        val translateTab = JPanel()
        translateTab.layout = BoxLayout(translateTab, BoxLayout.Y_AXIS)
        translateTab.add(JLabel("Input SQL"))
        translateTab.add(JTextArea("Editable Text Area in Tab 2", 5, 20))
        translateTab.add(JLabel("This is Tab 2"))
        translateTab.add(JTextArea("Editable Text Area in Tab 2", 5, 20))

        tabbedPane.addTab("", translateTab)

        return tabbedPane
    }

    override fun doOKAction() {
        super.doOKAction()
    }
}