package com.fiap.conversa.application.usecases

import com.fiap.conversa.domain.repositories.ConversationRepository
import com.fiap.conversa.application.viewmodels.ConversationResponse
import io.micronaut.context.annotation.Context

@Context
class GetAllConversationsUseCaseImpl(
    private val conversationRepository: ConversationRepository
) : GetAllConversationsUseCase {
    override fun execute(): List<ConversationResponse> {
        return conversationRepository.getAll().map { ConversationResponse(it.id, it.idInsuranceAgent, it.idClient) }
    }
}