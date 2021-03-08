package com.fiap.conversa.application.usecases

import com.fiap.conversa.domain.models.Conversation
import com.fiap.conversa.domain.repositories.ConversationRepository
import com.fiap.conversa.application.viewmodels.ConversationRequest
import com.fiap.conversa.application.viewmodels.ConversationResponse
import io.micronaut.context.annotation.Context

@Context
class CreateNewConversationUseCaseImpl(
    private val conversationRepository: ConversationRepository,
    private val getConversationUseCase: GetConversationUseCase
) : CreateNewConversationUseCase {
    override fun execute(conversation: ConversationRequest): ConversationResponse {
        val id = conversationRepository.addNew(Conversation(conversation.idClient, conversation.idInsuranceAgent))
        return getConversationUseCase.execute(id)
    }
}