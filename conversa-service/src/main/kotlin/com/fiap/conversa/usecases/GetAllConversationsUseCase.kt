package com.fiap.conversa.usecases

import com.fiap.conversa.viewmodels.ConversationResponse

interface GetAllConversationsUseCase {
    fun execute(): List<ConversationResponse>
}