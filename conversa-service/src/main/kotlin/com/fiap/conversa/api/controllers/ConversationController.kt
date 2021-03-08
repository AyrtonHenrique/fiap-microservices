package com.fiap.conversa.api.controllers

import com.fiap.conversa.application.usecases.CreateNewConversationUseCase
import com.fiap.conversa.application.usecases.GetAllConversationsUseCase
import com.fiap.conversa.application.usecases.GetConversationUseCase
import com.fiap.conversa.application.viewmodels.ConversationRequest
import com.fiap.conversa.application.viewmodels.ConversationResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller("/conversation")

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

    @Status(HttpStatus.CREATED)
    @Post
    fun addNew(@Body conversation: ConversationRequest): ConversationResponse {
        return _createNewConversationUseCase.execute(conversation)
//        return HttpResponse.status<ConversationResponse>(HttpStatus.CREATED)
//            .body(_createNewConversationUseCase.execute(conversation))
    }

    fun delete() {

    }

}