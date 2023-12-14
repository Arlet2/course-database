package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureDeliveriesRouting() {
    routing {
        post("$apiPath/deliveries") {

        }

        get("$apiPath/deliveries/{id}") {

        }

        delete("$apiPath/deliveries/{id}") {

        }

        delete("$apiPath/deliveries") {

        }

        get("$apiPath/deliveries") {
            // query by transport_number, delivery_point_id, factory_id
        }

        put ("$apiPath/deliveries/{id}") {

        }
    }
}