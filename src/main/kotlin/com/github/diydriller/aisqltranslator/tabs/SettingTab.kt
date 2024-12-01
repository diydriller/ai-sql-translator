package com.github.diydriller.aisqltranslator.tabs

import com.github.diydriller.aisqltranslator.services.GlobalDataService
import java.awt.*
import javax.swing.*

class SettingTab : JPanel() {
    private var apiKeyInputField = JTextField()
    private var fromSqlDropdown: JComboBox<String> = JComboBox(arrayOf("tibero", "postgreSQL"))
    private var toSqlDropdown: JComboBox<String> = JComboBox(arrayOf("tibero", "postgreSQL"))
    private val saveButton = JButton("Save")

    init {
        layout = GridBagLayout()
        val gbc = GridBagConstraints()
        gbc.insets = Insets(10, 10, 10, 10)

        gbc.gridy = 0
        gbc.weighty = 1.0
        add(Box.createVerticalGlue(), gbc)

        // Input
        gbc.gridx = 0
        gbc.gridy = 1
        gbc.gridwidth = 1
        gbc.weighty = 0.0
        gbc.anchor = GridBagConstraints.WEST
        add(JLabel("API Key"), gbc)

        gbc.gridx = 1
        gbc.gridwidth = 3
        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.weightx = 1.0
        add(apiKeyInputField, gbc)

        gbc.gridx = 0
        gbc.gridy = 2
        gbc.gridwidth = 4
        gbc.fill = GridBagConstraints.NONE
        add(Box.createVerticalStrut(10), gbc)


        // Dropdown
        gbc.gridwidth = 1
        gbc.gridx = 0
        gbc.gridy = 3
        gbc.insets = Insets(5, 10, 5, 5)
        add(JLabel("Input Select"), gbc)

        gbc.gridx = 1
        gbc.insets = Insets(5, 5, 5, 20)
        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.weightx = 0.5
        add(fromSqlDropdown, gbc)

        gbc.gridx = 2
        gbc.weightx = 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL
        add(Box.createHorizontalGlue(), gbc)

        gbc.gridx = 3
        gbc.insets = Insets(5, 10, 5, 5)
        add(JLabel("Output Select"), gbc)

        gbc.gridx = 4
        gbc.insets = Insets(5, 5, 5, 10)
        gbc.fill = GridBagConstraints.HORIZONTAL
        add(toSqlDropdown, gbc)

        // Button
        gbc.gridx = 0
        gbc.gridy = 5
        gbc.gridwidth = 5
        gbc.anchor = GridBagConstraints.CENTER
        gbc.fill = GridBagConstraints.NONE
        gbc.weighty = 1.0
        saveButton.preferredSize = Dimension(100, 30)
        saveButton.addActionListener {
            saveData()
        }
        add(saveButton, gbc)

        gbc.gridy = 5
        add(Box.createVerticalGlue(), gbc)
    }

    private fun saveData() {
        val globalDataService = GlobalDataService.getInstance()
        globalDataService.aiApiKey = apiKeyInputField.text
        globalDataService.selectedFromSql = fromSqlDropdown.selectedItem?.toString()
        globalDataService.selectedToSql = toSqlDropdown.selectedItem?.toString()

        JOptionPane.showMessageDialog(this, "Setting Saved", "Save", JOptionPane.INFORMATION_MESSAGE)
    }

}