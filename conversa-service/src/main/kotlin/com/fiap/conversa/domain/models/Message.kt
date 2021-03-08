package com.fiap.conversa.domain.models


data class Message(
    val idSender: String,
    val textMessage: String,
    val sendByInsurerAgent: Boolean
) {

}