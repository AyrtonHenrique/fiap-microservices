package com.fiap.conversa.domain.repositories

import com.fiap.conversa.domain.models.Conversation
import com.fiap.conversa.domain.models.Message

interface ConversationRepository {
    fun addNew(conversation: Conversation): String
    fun sendMessage(idConversation: String, message: Message)
    fun getAll(): List<Conversation>
    fun getById(idConversation: String): Conversation
}