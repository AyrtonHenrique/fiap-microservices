package com.fiap.conversa.application.viewmodels

import javax.validation.constraints.NotBlank

class ConversationRequest(
    @NotBlank
    val idClient: String,
    @NotBlank
    val idInsuranceAgent: String
) {
}