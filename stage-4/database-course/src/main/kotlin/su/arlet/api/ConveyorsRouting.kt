package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureConveyorsRouting() {
    routing {
        post("$apiPath/conveyors") {

        }

        get("$apiPath/conveyors/{id}") {

        }


        delete("$apiPath/conveyors/{id}") {

        }

        get("$apiPath/conveyors") {
            // query by pelmeni_type, pelmeni_size, manager_id, commissioning_date (before, after)
        }

        put("$apiPath/conveyors") {

        }
    }
}