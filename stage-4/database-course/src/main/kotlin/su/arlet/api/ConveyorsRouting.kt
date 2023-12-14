package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.greater
import org.jetbrains.exposed.sql.SqlExpressionBuilder.less
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import su.arlet.apiPath
import su.arlet.entities.*
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

fun Application.configureConveyorsRouting() {
    routing {
        post("$apiPath/conveyors") {
            val conveyor = call.receive<ConveyorEntity>()
            transaction {
                ConveyorEntity.new {
                    this.managerID = conveyor.managerID
                    this.name = conveyor.name
                    this.commissioningDate = conveyor.commissioningDate
                    this.decommissioningDate = conveyor.decommissioningDate
                }
            }
        }

        get("$apiPath/conveyors/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw BadRequestException("bad id")
            call.respond(ConveyorEntity[id])
        }


        delete("$apiPath/conveyors/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
            transaction {
                BatchEntity[id].delete()
            }
        }

        get("$apiPath/conveyors") {
            // query by manager_id, commissioning_date (before, after)
            val id = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
            val managerID = call.request.queryParameters["manager_id"]?.toIntOrNull()
            val commissionDateBefore = LocalDate.parse(call.request.queryParameters["package_time_before"])
            val commissionDateAfter = LocalDate.parse(call.request.queryParameters["package_time_after"])

            Conveyors.select {
                (Conveyors.id eq id) and
                        (Conveyors.managerID eq managerID) and
                        (Conveyors.commissioningDate less commissionDateBefore) and
                        (Conveyors.commissioningDate greater commissionDateAfter)
            }
        }
    }
}