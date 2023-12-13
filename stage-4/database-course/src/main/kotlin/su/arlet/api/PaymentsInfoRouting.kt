package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configurePaymentsRouting() {
    routing {
        get("$apiPath/payments") {
            // query by bank, owner
        }

        get("$apiPath/payments/{id}") {

        }

        post("$apiPath/payments") {

        }

        delete("$apiPath/payments/{id}") {

        }

    }
}