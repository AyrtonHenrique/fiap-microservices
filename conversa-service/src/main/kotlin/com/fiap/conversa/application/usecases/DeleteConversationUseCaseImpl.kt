package com.fiap.conversa.application.usecases

import com.fiap.conversa.domain.repositories.ConversationRepository
import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class DeleteConversationUseCaseImpl(
    private val conversationRepository: ConversationRepository
) : DeleteConversationUseCase {
    override fun execute(idConversation: String) {
        conversationRepository.delete(idConversation)
    }
}