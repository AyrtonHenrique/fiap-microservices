package com.fiap.conversa

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "conversa-service",
        version = "0.0"
    )
)
object ApplicationKt  {
    @JvmStatic
    fun main(args: Array<String>) {
        build()
            .args(*args)
            .packages("com.fiap.conversa")
            .start()
    }
}


