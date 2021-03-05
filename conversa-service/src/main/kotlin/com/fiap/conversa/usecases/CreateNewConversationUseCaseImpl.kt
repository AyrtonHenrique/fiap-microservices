package com.fiap.conversa.usecases

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.repositories.ConversationRepository
import com.fiap.conversa.viewmodels.ConversationRequest
import io.micronaut.context.annotation.Context

@Context
class CreateNewConversationUseCaseImpl(
    private val conversationRepository: ConversationRepository
) : CreateNewConversationUseCase {
    override fun execute(conversation: ConversationRequest): String {
        return conversationRepository.addNew(Conversation(conversation.idClient, conversation.idInsuranceAgent))
    }
}