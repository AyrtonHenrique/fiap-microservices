package com.fiap.conversa.infra.extension

import com.fiap.conversa.infra.viewmodels.ConversationMongoResponse
import com.fiap.conversa.infra.viewmodels.MessageMongoResponse
import com.fiap.conversa.models.Conversation
import com.fiap.conversa.models.Message

fun Conversation.toViewModelMongo(): ConversationMongoResponse {
    return ConversationMongoResponse(
        this.id,
        emptyList(),
        this.idInsuranceAgent,
        this.idClient
    )
}

fun Message.toViewModelMongo(): MessageMongoResponse {
    return MessageMongoResponse(
        this.idSender,
        this.textMessage,
        this.sendByInsurerAgent
    )
}