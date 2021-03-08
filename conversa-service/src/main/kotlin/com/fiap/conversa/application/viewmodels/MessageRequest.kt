package com.fiap.conversa.application.viewmodels

import javax.validation.constraints.NotBlank

data class MessageRequest(
    @NotBlank
    val idSender: String,
    @NotBlank
    val textMessage: String,
    @NotBlank
    val sendByInsurerAgent: Boolean
) {
}