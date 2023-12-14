package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configurePelmeniSizeRouting() {
    routing {
        post("$apiPath/pelmeni_size") {

        }

        get("$apiPath/pelmeni_size/{name}") {

        }

        delete("$apiPath/pelmeni_size/{name}") {

        }

        get("$apiPath/pelmeni_size") {

        }

        put("$apiPath/pelmeni_size") {

        }
    }
}