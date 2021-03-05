package com.fiap.conversa.models

import org.bson.codecs.pojo.annotations.BsonDiscriminator


data class Message(
    val idSender: String,
    val textMessage: String,
    val sendByInsurerAgent: Boolean
) {

}