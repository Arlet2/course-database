package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureTransportsRouting() {
    routing {
        post("$apiPath/transports") {

        }

        get("$apiPath/transports/{id}") {

        }

        delete("$apiPath/transports/{id}") {

        }

        get("$apiPath/transports") {

        }

        put ("$apiPath/transports/{id}") {

        }
    }
}