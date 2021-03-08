package com.fiap.conversa.application.usecases

import com.fiap.conversa.application.viewmodels.MessageRequest

interface SendMessageConversationUseCase {
    fun execute(idConversation: String, message: MessageRequest)
}