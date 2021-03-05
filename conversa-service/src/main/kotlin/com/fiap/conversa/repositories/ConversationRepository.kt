package com.fiap.conversa.repositories

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.models.Message

interface ConversationRepository {
    fun addNew(conversation: Conversation): String
    fun sendMessage(idConversation: String, message: Message)
    fun getAll(): List<Conversation>
    fun getById(idConversation: String): Conversation
}