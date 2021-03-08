package com.fiap.conversa.application.usecases

import com.fiap.conversa.domain.models.Message
import com.fiap.conversa.domain.repositories.ConversationRepository
import com.fiap.conversa.application.viewmodels.MessageRequest
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