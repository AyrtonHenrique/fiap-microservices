package com.fiap.conversa.controllers

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.usecases.CreateNewConversationUseCase
import com.fiap.conversa.usecases.GetAllConversationsUseCase
import com.fiap.conversa.usecases.GetConversationUseCase
import com.fiap.conversa.viewmodels.ConversationRequest
import com.fiap.conversa.viewmodels.ConversationResponse
import com.fiap.conversa.viewmodels.MessageRequest
import io.micronaut.http.annotation.*

@Controller("conversation")
class ConversationController(
    private val _getAllConversationsUseCase: GetAllConversationsUseCase,
    private val _createNewConversationUseCase: CreateNewConversationUseCase,
    private val _getConversationUseCase: GetConversationUseCase

) {

    @Get()
    fun getAll(): List<ConversationResponse> {
        return _getAllConversationsUseCase.execute()
    }

    @Get("/{idConversation}")
    fun getById(@PathVariable idConversation: String): ConversationResponse {
        return _getConversationUseCase.execute(idConversation)
    }

    @Post
    fun addNew(@Body conversation: ConversationRequest): String {
        return _createNewConversationUseCase.execute(conversation)
    }

    fun delete() {

    }

}