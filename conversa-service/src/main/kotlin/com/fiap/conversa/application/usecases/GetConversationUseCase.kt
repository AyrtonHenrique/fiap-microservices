package com.fiap.conversa.application.usecases

import com.fiap.conversa.application.viewmodels.ConversationResponse

interface GetConversationUseCase {
    fun execute(idConversation: String): ConversationResponse
}