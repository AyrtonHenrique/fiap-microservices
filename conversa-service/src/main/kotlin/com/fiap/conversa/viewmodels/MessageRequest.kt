package com.fiap.conversa.viewmodels

data class MessageRequest(
    val idSender: String,
    val textMessage: String,
    val sendByInsurerAgent: Boolean
) {
}