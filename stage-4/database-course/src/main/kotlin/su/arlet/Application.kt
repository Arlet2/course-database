package su.arlet

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import su.arlet.entities.Documents
import su.arlet.entities.Employees
import su.arlet.entities.PaymentsInfo
import su.arlet.plugins.*

const val databaseUsername = "postgres"
const val databasePassword = "mysecretpassword"
const val databaseName = "postgres"

const val databaseHost = "localhost"
const val databasePort = "5432"

const val databaseURL = "jdbc:postgresql://$databaseHost:$databasePort/$databaseName"
const val driverClassName = "org.postgresql.Driver"

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val database = Database.connect(
        url = databaseURL,
        driver = driverClassName,
        user = databaseUsername,
        password = databasePassword
    )

    transaction(database) {
        SchemaUtils.create(Documents, Employees, PaymentsInfo)
    }

    configureHTTP()
    configureSerialization()
    configureRouting()
}
