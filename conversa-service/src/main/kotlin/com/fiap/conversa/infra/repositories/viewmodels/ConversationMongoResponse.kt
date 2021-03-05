package com.fiap.conversa.infra.repositories.viewmodels

import com.fiap.conversa.models.Message
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator
data class ConversationMongoResponse(
    val id: String = "",
    val messages: List<Message> = arrayListOf(),
    val idInsuranceAgent: String = "",
    val idClient: String = "",
    val nameClient: String = "",
    val InsuranceAgent: String = ""
) {
}