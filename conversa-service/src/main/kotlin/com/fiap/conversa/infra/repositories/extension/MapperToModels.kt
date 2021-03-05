package com.fiap.conversa.infra.repositories.extension

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.viewmodels.ConversationResponse

fun ConversationResponse.toConversationModel() : Conversation {
    return Conversation(
        this.id,
        this.messages.toMessagesModels(),
        this.idInsuranceAgent,
        this.idClient
    )
}


fun 