package com.fiap.conversa.infra.viewmodels

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator
class MessageMongoResponse(
    var idSender: String = "",
    var textMessage: String = "",
    var sendByInsurerAgent: Boolean = false
) {
}