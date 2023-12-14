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

        get("$apiPath/employees/{id}/payments") {
            // query by bank name
        }

        get("$apiPath/employees/{id}/payments/{payment_id}") {

        }

        post("$apiPath/employees/{id}/payments") {

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