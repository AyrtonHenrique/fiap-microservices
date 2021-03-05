package com.fiap.conversa.infra.extension

import com.fiap.conversa.infra.viewmodels.ConversationMongoResponse
import com.fiap.conversa.infra.viewmodels.MessageMongoResponse
import com.fiap.conversa.models.Conversation
import com.fiap.conversa.models.Message

fun ConversationMongoResponse.toConversationModel(): Conversation {
    return Conversation(
        this.id,
        this.messages.toMessagesModels(),
        this.idInsuranceAgent,
        this.idClient
    )
}

fun List<ConversationMongoResponse>.toConversationsModels(): List<Conversation> {
    return this.map { it.toConversationModel() }
}

fun List<MessageMongoResponse>.toMessagesModels(): List<Message> {
    return this.map {
        Message(it.idSender, it.textMessage, it.sendByInsurerAgent)
    }
}