package com.fiap.conversa.controllers

import com.fiap.conversa.models.Conversation
import com.fiap.conversa.usecases.CreateNewConversationUseCase
import com.fiap.conversa.usecases.GetAllConversationsUseCase
import com.fiap.conversa.viewmodels.ConversationRequest
import com.fiap.conversa.viewmodels.ConversationResponse
import com.fiap.conversa.viewmodels.MessageRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("conversation")
class ConversationController(
    private val _getAllConversationsUseCase: GetAllConversationsUseCase,
    private val _createNewConversationUseCase: CreateNewConversationUseCase

) {

    @Get()
    fun getAll(): List<ConversationResponse> {
        return _getAllConversationsUseCase.execute()
    }

//    fun getById(): ConversationResponse {
//        return ConversationResponse()
//    }

    @Post
    fun addNew(@Body conversation: ConversationRequest) : String{
        return _createNewConversationUseCase.execute(conversation)
    }

    fun delete() {

    }

}