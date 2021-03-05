package com.fiap.conversa.usecases

import com.fiap.conversa.viewmodels.ConversationRequest

interface CreateNewConversationUseCase {
    fun execute(conversation : ConversationRequest) : String
}