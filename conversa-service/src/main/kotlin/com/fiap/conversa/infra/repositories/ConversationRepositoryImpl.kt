package com.fiap.conversa.infra.repositories

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.models.Message
import com.fiap.conversa.repositories.ConversationRepository
import com.fiap.conversa.viewmodels.ConversationResponse
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates.push
import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class ConversationRepositoryImpl(
    private val _mongoClient: MongoClient
) : ConversationRepository {
    private val collection =
        _mongoClient.getDatabase("conversation-service").getCollection("conversations", Conversation::class.java)

    override fun addNew(conversation: Conversation): String {
//        val doc = ConversationResponse
        return collection.insertOne()?.insertedId?.asString()?.value ?: ""
    }

    override fun getById(idConversation: String): Conversation {

        return collection.find(eq("_id", idConversation))?.first() ?: Conversation()
    }

    override fun getAll(): List<Conversation> {

        return collection.find().toList()
    }

    override fun sendMessage(idConversation: String, message: Message) {

        collection.updateOne(eq("_id", idConversation), push("messages", message))
    }
}