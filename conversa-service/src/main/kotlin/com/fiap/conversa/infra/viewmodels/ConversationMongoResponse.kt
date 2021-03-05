package com.fiap.conversa.infra.viewmodels

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator
class ConversationMongoResponse(
    var id: String = "",
    var messages: List<MessageMongoResponse> = arrayListOf(),
    var idInsuranceAgent: String = "",
    var idClient: String = "",
    var nameClient: String = "",
    var InsuranceAgent: String = ""
) {
}