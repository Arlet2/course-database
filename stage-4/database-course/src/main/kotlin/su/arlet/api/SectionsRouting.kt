package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureSectionsRouting() {
    routing {
        post("$apiPath/sections") {

        }

        get("$apiPath/sections/{id}") {

        }

        delete("$apiPath/sections/{id}") {

        }

        get("$apiPath/sections") {
            // query by temperature (greater, lower), load_date (before, after), unload_date
            // ..batch_id
        }

        put("$apiPath/sections") {

        }
    }
}