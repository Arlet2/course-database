package su.arlet

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import su.arlet.api.configureEmployeesRouting
import su.arlet.entities.Documents
import su.arlet.entities.Employees
import su.arlet.entities.PaymentsInfo
import su.arlet.plugins.*

const val driverClassName = "org.postgresql.Driver"

const val apiPrefix = "fabric/api"
const val apiVersion = "v1"
const val apiPath = "$apiPrefix/$apiVersion"
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val url = "jdbc:postgresql://" +
            environment.config.property("database.host").getString() +
            ":" + environment.config.property("database.port").getString() +
            "/" + environment.config.property("database.name").getString()
    val database = Database.connect(
        url = url,
        driver = driverClassName,
        user = environment.config.property("database.username").getString(),
        password = environment.config.property("database.password").getString()
    )

    transaction(database) {
        SchemaUtils.create(Documents, Employees, PaymentsInfo)
    }

    configureHTTP()
    configureSerialization()

    configureRouting()
}

fun Application.configureRouting() {
    configureEmployeesRouting()
}