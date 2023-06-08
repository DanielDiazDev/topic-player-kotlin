package com.twister.topic

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.twister.topic.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import routes.registerPlayerRoutes

fun main() {

    val port = System.getenv("PORT")?.toInt() ?: 8080
    embeddedServer(Netty, port = port, host = "0.0.0.0", module = Application::module).start(wait = true)

    //embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        //.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation){
        json()
    }


    configureRouting()
    registerPlayerRoutes()
}
