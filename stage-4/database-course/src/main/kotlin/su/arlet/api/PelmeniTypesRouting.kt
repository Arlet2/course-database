package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configurePelmeniTypesRouting() {
    routing {
        post("$apiPath/pelmeni_types") {

        }

        get("$apiPath/pelmeni_types/{id}") {

        }

        get("$apiPath/pelmeni_types/{id}/ingredients") {
            // query by name
        }

        delete("$apiPath/pelmeni_types/{id}") {

        }

        get("$apiPath/pelmeni_types") {
            // query by name
        }

        put("$apiPath/pelmeni_types") {

        }
    }
}