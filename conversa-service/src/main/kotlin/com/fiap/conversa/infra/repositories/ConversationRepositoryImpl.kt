package com.fiap.conversa.infra.repositories

import com.fiap.conversa.infra.extension.toConversationModel
import com.fiap.conversa.infra.extension.toConversationsModels
import com.fiap.conversa.infra.extension.toViewModelMongo
import com.fiap.conversa.infra.viewmodels.ConversationMongoResponse
import com.fiap.conversa.domain.models.Conversation
import com.fiap.conversa.domain.models.Message
import com.fiap.conversa.domain.repositories.ConversationRepository
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates.push
import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class ConversationRepositoryImpl(
    private val _mongoClient: MongoClient
) : ConversationRepository {
    private val collection =
        _mongoClient.getDatabase("conversation-service")
            .getCollection("conversations", ConversationMongoResponse::class.java)

    override fun addNew(conversation: Conversation): String {
        val doc = conversation.toViewModelMongo()
        return collection.insertOne(doc)?.insertedId?.asString()?.value ?: ""
    }

    override fun getById(idConversation: String): Conversation {
        val doc = collection.find(eq("_id", idConversation))?.first() ?: ConversationMongoResponse()
        return doc.toConversationModel()
    }

    override fun delete(idConversation: String) {
        collection.deleteOne(eq("_id", idConversation))
    }

    override fun getAll(): List<Conversation> {

        return collection.find().toList().toConversationsModels()
    }

    override fun sendMessage(idConversation: String, message: Message) {
        val doc = message.toViewModelMongo()
        collection.updateOne(eq("_id", idConversation), push("messages", message))
    }
}