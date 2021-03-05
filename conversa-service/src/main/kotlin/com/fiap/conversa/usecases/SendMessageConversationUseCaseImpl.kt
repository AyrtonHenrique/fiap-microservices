package com.fiap.conversa.usecases

import com.fiap.conversa.models.Message
import com.fiap.conversa.repositories.ConversationRepository
import com.fiap.conversa.viewmodels.MessageRequest
import io.micronaut.context.annotation.Context

@Context
class SendMessageConversationUseCaseImpl(
    private val conversationRepository: ConversationRepository
) : SendMessageConversationUseCase {
    override fun execute(idConversation: String, message: MessageRequest) {
        conversationRepository.sendMessage(
            idConversation,
            Message(message.idSender, message.textMessage, message.sendByInsurerAgent)
        )
    }
}