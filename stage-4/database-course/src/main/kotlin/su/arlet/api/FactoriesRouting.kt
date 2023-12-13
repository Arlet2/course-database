package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureFactoriesRouting() {
    routing {
        get("$apiPath/factories") {

        }

        get("$apiPath/factories/{id}") {

        }

        post("$apiPath/factories") {

        }

        delete("$apiPath/factories/{id}") {

        }

    }
}