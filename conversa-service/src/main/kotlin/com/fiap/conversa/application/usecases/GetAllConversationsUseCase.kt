package com.fiap.conversa.application.usecases

import com.fiap.conversa.application.viewmodels.ConversationResponse

interface GetAllConversationsUseCase {
    fun execute(): List<ConversationResponse>
}