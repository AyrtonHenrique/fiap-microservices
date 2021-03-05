package com.fiap.conversa.models

import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.hibernate.id.GUIDGenerator
import java.util.*


data class Conversation(
    val id: String = "",
    val messages: List<Message> = arrayListOf(),
    val idInsuranceAgent: String = "",
    val idClient: String = "",
    val nameClient: String = "",
    val InsuranceAgent: String = ""
) {
    constructor(idClient: String, idInsuranceAgent: String) : this(
        UUID.randomUUID().toString(),
        arrayListOf(),
        idInsuranceAgent,
        idClient
    )
}