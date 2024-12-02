package com.github.diydriller.aisqltranslator.tabs

import com.github.diydriller.aisqltranslator.services.GlobalDataService
import com.github.diydriller.aisqltranslator.services.OpenAiService
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

class TranslateTab : JPanel() {
    private var fromSqlEditorPane = JEditorPane("text/plain", "")
    private var toSqlEditorPane = JEditorPane("text/plain", "")
    private val applyButton = JButton("Apply")
    private val openAiService = OpenAiService()

    init {
        layout = GridBagLayout()
        val gbc = GridBagConstraints()

        gbc.insets = Insets(10, 10, 10, 10)

        gbc.gridx = 0
        gbc.gridy = 0
        gbc.anchor = GridBagConstraints.WEST
        gbc.weightx = 0.5
        gbc.fill = GridBagConstraints.NONE
        add(JLabel("Input"), gbc)

        gbc.gridx = 1
        gbc.gridy = 0
        gbc.gridheight = 2
        gbc.weightx = 0.1
        gbc.fill = GridBagConstraints.HORIZONTAL
        add(Box.createHorizontalGlue(), gbc)


        gbc.gridx = 2
        gbc.gridy = 0
        gbc.anchor = GridBagConstraints.WEST
        gbc.fill = GridBagConstraints.NONE
        gbc.weightx = 0.5
        add(JLabel("Output"), gbc)


        gbc.gridx = 0
        gbc.gridy = 1
        gbc.fill = GridBagConstraints.BOTH
        gbc.weightx = 0.5
        gbc.weighty = 1.0
        fromSqlEditorPane.isEditable = true
        val fromSqlScrollPane = JScrollPane(fromSqlEditorPane)
        fromSqlScrollPane.minimumSize = Dimension(250, 150)
        fromSqlScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        add(fromSqlScrollPane, gbc)

        gbc.gridx = 2
        gbc.gridy = 1
        gbc.fill = GridBagConstraints.BOTH
        gbc.weightx = 0.5
        gbc.weighty = 1.0
        toSqlEditorPane.isEditable = true
        val toSqlScrollPane = JScrollPane(toSqlEditorPane)
        toSqlScrollPane.minimumSize = Dimension(250, 150)
        toSqlScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        add(toSqlScrollPane, gbc)

        gbc.gridx = 0
        gbc.gridy = 3
        gbc.gridwidth = 3
        gbc.fill = GridBagConstraints.NONE
        gbc.anchor = GridBagConstraints.CENTER
        gbc.weightx = 0.0
        gbc.weighty = 0.0

        applyButton.preferredSize = Dimension(100, 30)
        applyButton.addActionListener {
            performTranslation()
        }
        add(applyButton, gbc)
    }

    private fun performTranslation() {
        val sql = openAiService.translateSql(
            GlobalDataService.getInstance().selectedFromSql!!,
            GlobalDataService.getInstance().selectedToSql!!,
            fromSqlEditorPane.text
        )
        toSqlEditorPane.text = sql
        JOptionPane.showMessageDialog(this, "Translation Success")
    }
}