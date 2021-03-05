package com.fiap.conversa.usecases

import com.fiap.conversa.viewmodels.ConversationResponse
import com.fiap.conversa.viewmodels.MessageRequest

interface SendMessageConversationUseCase {
    fun execute(idConversation: String, message: MessageRequest)
}