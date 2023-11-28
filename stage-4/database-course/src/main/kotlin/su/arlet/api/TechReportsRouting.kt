package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureTechReportsRouting() {
    routing {
        post("$apiPath/tech_reports") {

        }

        get("$apiPath/tech_reports/{id}") {

        }

        delete("$apiPath/tech_reports/{id}") {

        }

        get("$apiPath/tech_reports") {
            // query by shift_id, reporter_id, state
        }

        put("$apiPath/work_shifts") {

        }
    }
}