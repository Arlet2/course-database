package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureBatchesRouting() {
    routing {
        post("$apiPath/batches") {

        }

        get("$apiPath/batches/{id}") {

        }

        delete("$apiPath/batches/{id}") {

        }

        get("$apiPath/batches") {
            // query by shift_id, pelmeni_type, pelmeni_size, created (before, after)
            // ..factory_id, package_time (before, after)
        }

        put("$apiPath/batches") {

        }
    }
}