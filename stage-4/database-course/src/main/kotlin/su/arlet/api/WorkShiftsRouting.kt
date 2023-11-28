package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureWorkShiftsRouting() {
    routing {
        post("$apiPath/work_shifts") {

        }

        get("$apiPath/work_shifts/{id}") {

        }

        get("$apiPath/work_shifts/{id}/employees") {
            // query by shift_manager
        }

        delete("$apiPath/work_shifts/{id}") {

        }

        get("$apiPath/work_shifts") {
            // query by conveyour_id, time_start (after, before), time_end(before, after)
        }

        put("$apiPath/work_shifts") {

        }
    }
}