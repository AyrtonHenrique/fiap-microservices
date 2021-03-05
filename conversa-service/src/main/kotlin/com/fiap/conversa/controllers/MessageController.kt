package com.fiap.conversa.controllers

import com.fiap.conversa.usecases.SendMessageConversationUseCase
import com.fiap.conversa.viewmodels.MessageRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("conversation/{idConversation}/message")
class MessageController(
    private val sendMessageConversationUseCase: SendMessageConversationUseCase
) {

    @Post()
    fun newMessage(@PathVariable idConversation: String, @Body message: MessageRequest): String {
        sendMessageConversationUseCase.execute(idConversation, message)
        return "oi ${idConversation}"
    }
}