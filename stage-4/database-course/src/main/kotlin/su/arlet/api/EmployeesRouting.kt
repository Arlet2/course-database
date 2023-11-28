package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import su.arlet.apiPath

fun Application.configureEmployeesRouting() {
    routing {
        post("$apiPath/employees") {

        }

        get("$apiPath/employees/{id}") {

        }

        delete("$apiPath/employees/{id}") {

        }

        get("$apiPath/employees") {
            // query by fullname, employment_date, job_title
        }

        put ("$apiPath/employees/{id}") {

        }
    }
}