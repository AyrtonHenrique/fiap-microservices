package com.fiap.conversa.usecases

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.repositories.ConversationRepository
import com.fiap.conversa.viewmodels.ConversationResponse
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