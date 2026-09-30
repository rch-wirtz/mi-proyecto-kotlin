package org.example.project.server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.sql.DriverManager

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        routing {
            get("/health") {
                call.respondText("ok")
            }
            get("/db-check") {
                val version = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/appdb", "dev", "devpass"
                ).use { conn ->
                    conn.createStatement().executeQuery("SELECT VERSION()").use { rs ->
                        rs.next()
                        rs.getString(1)
                    }
                }
                call.respondText("Conectado a MySQL, versión: $version")
            }
        }
    }.start(wait = true)
}
