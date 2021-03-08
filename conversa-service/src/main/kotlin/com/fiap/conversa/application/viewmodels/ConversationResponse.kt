package com.fiap.conversa.application.viewmodels

import com.fiap.conversa.domain.models.Message

class ConversationResponse(
    val id: String,
    val idInsuranceAgent: String,
    val idClient: String,
    val messages: List<Message> = emptyList()
) {
}