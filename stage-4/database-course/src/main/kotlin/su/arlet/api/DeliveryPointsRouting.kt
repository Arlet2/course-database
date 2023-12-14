package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureDeliveryPointsRouting() {
    routing {
        post("$apiPath/delivery_points") {

        }

        get("$apiPath/delivery_points/{id}") {

        }

        delete("$apiPath/delivery_points/{id}") {

        }

        get("$apiPath/delivery_points") {
            // query by point_type
        }

        put ("$apiPath/delivery_points/{id}") {

        }
    }
}