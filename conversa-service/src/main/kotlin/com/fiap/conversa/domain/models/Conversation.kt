package com.fiap.conversa.domain.models

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