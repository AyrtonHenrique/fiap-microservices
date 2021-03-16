package com.fiap.conversa.presentation.api.controllers.v1

import com.fiap.conversa.application.usecases.CreateNewConversationUseCase
import com.fiap.conversa.application.usecases.GetAllConversationsUseCase
import com.fiap.conversa.application.usecases.GetConversationUseCase
import com.fiap.conversa.application.viewmodels.ConversationRequest
import com.fiap.conversa.application.viewmodels.ConversationResponse
import io.micronaut.core.version.annotation.Version
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Version("1")
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
    }

    fun delete() {

    }

}