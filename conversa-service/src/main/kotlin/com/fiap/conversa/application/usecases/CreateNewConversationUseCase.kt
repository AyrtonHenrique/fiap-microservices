package com.fiap.conversa.application.usecases

import com.fiap.conversa.application.viewmodels.ConversationRequest
import com.fiap.conversa.application.viewmodels.ConversationResponse

interface CreateNewConversationUseCase {
    fun execute(conversation : ConversationRequest) : ConversationResponse
}