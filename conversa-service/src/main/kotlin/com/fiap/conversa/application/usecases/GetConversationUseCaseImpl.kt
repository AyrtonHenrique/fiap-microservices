package com.fiap.conversa.application.usecases

import com.fiap.conversa.domain.repositories.ConversationRepository
import com.fiap.conversa.application.viewmodels.ConversationResponse
import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class GetConversationUseCaseImpl(
    private val conversationRepository: ConversationRepository
) : GetConversationUseCase {
    override fun execute(idConversation: String): ConversationResponse {

        val conversation = conversationRepository.getById(idConversation)

        return ConversationResponse(
            conversation.id,
            conversation.idInsuranceAgent,
            conversation.idClient,
            conversation.messages
        )
    }
}