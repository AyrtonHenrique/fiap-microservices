package com.fiap.conversa.infra.repositories.viewmodels

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator
class MessageMongoResponse(
    val idSender: String,
    val textMessage: String,
    val sendByInsurerAgent: Boolean
) {
}