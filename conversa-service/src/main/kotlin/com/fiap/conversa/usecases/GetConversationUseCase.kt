package com.fiap.conversa.usecases

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.viewmodels.ConversationResponse

interface GetConversationUseCase {
    fun execute(idConversation: String): ConversationResponse
}