package su.arlet

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import su.arlet.api.*
import su.arlet.entities.*
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
    val host = "localhost"
    val port = "5432"
    val username = "postgres"
    val password = "mysecretpassword"
    val name = "postgres"


    val url = "jdbc:postgresql://" +
            host +
            ":" + port +
            "/" + name
    val database = Database.connect(
        url = url,
        driver = driverClassName,
        user = username,
        password = password
    )

    transaction(database) {
        initDatabase()
    }

    configureHTTP()
    configureSerialization()

    configureRouting()
}

fun Application.configureRouting() {
    configureBatchesRouting()
    configureConveyorsRouting()
    configureDeliveriesRouting()
    configureDocumentsRouting()
    configureEmployeesRouting()
    configureFactoriesRouting()
    configurePaymentsRouting()
    configurePelmeniSizeRouting()
    configurePelmeniTypesRouting()
    configureSectionsRouting()
    configureTechReportsRouting()
    configureTransportsRouting()
    configureWorkShiftsRouting()
}

fun initDatabase() {
    SchemaUtils.create(
        Batches, BatchDeliveries, Conveyors,
        ConveyorPelmenies, Deliveries, DeliveryPoints,
        DeliveryPointTypes, Documents, Employees,
        Factories, PaymentsInfo, PelmeniSizes,
        PelmeniTypes, PelmeniTypeIngredients, Sections,
        TechReports, Transports, WorkShifts,
        WorkShiftEmployees
    )
}