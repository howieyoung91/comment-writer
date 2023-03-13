/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.aicodehelper.ai.chatgpt.config

import com.github.howieyoung91.aicodehelper.ui.OnlyFloatTextField
import com.github.howieyoung91.aicodehelper.ui.OnlyNumberTextField
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class ChatGPTConfigPanel {
    val panel: JPanel
    private val apikeyInput = JBTextField()
    private val maxTokenInput = OnlyNumberTextField()
    private val temperatureInput = OnlyFloatTextField()
    private val promptTemplateInput = JBTextArea()
    private val outputTemplateInput = JBTextArea()
    private val modelsComboBox = ComboBox(COMPLETION_MODELS)

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("API key:"), apikeyInput, 1, false)
            .addLabeledComponent(JBLabel("Max token:"), maxTokenInput, 1, false)
            .addLabeledComponent(JBLabel("Temperature:"), temperatureInput, 1, false)
            .addLabeledComponent(JBLabel("Prompt template:"), promptTemplateInput, 1, false)
            .addLabeledComponent(JBLabel("Output template:"), outputTemplateInput, 1, false)
            .addLabeledComponent(JBLabel("Models:"), modelsComboBox, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val preferredFocusedComponent: JComponent = apikeyInput

    var apikey: String
        get() = apikeyInput.text
        set(newApiKey) {
            apikeyInput.text = newApiKey
        }

    var model: String
        get() = modelsComboBox.item
        set(newModel) {
            val index = COMPLETION_MODELS_MAP[newModel] ?: 0
            modelsComboBox.selectedIndex = index
        }

    var maxToken: String
        get() = maxTokenInput.text
        set(newModel) {
            maxTokenInput.text = newModel
        }

    var temperature: String
        get() = temperatureInput.text
        set(newTemperature) {
            temperatureInput.text = newTemperature
        }

    var promptTemplate: String
        get() = promptTemplateInput.text
        set(newTemplate) {
            promptTemplateInput.text = newTemplate
        }

    var outputTemplate: String
        get() = outputTemplateInput.text
        set(newTemplate) {
            outputTemplateInput.text = newTemplate
        }
}
