package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureDocumentsRouting() {
    routing {
        post("$apiPath/documents") {

        }

        get("$apiPath/documents/{id}") {

        }

        delete("$apiPath/documents/{id}") {

        }

        delete("$apiPath/documents") {
            // query by owner_id
        }

        get("$apiPath/documents") {
            // query by owner_id
        }

        put ("$apiPath/documents/{id}") {

        }
    }
}