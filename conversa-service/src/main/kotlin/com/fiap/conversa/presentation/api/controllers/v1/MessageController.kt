package com.fiap.conversa.presentation.api.controllers.v1

import com.fiap.conversa.application.usecases.GetConversationUseCase
import com.fiap.conversa.application.usecases.SendMessageConversationUseCase
import com.fiap.conversa.application.viewmodels.MessageRequest
import com.fiap.conversa.domain.models.Message
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller("/conversation/{idConversation}/message")
class MessageController(
    private val sendMessageConversationUseCase: SendMessageConversationUseCase,
    private val getConversationUseCase: GetConversationUseCase
) {

    @Status(HttpStatus.CREATED)
    @Post()
    fun newMessage(@PathVariable idConversation: String, @Body message: MessageRequest) {
        sendMessageConversationUseCase.execute(idConversation, message)
    }

    @Get()
    fun getAllMessages(@PathVariable idConversation: String): List<Message> {
        return getConversationUseCase.execute(idConversation).messages
    }
}