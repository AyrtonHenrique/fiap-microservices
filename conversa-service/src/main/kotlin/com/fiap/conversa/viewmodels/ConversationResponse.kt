package com.fiap.conversa.viewmodels

import com.fiap.conversa.infra.viewmodels.MessageMongoResponse
import com.fiap.conversa.models.Message

class ConversationResponse(
    val id: String,
    val idInsuranceAgent: String,
    val idClient: String,
    val messages: List<Message> = emptyList()
) {
}