package su.arlet.api

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import su.arlet.apiPath
import su.arlet.entities.Batch
import su.arlet.entities.BatchEntity
import su.arlet.entities.Batches
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

fun Application.configureBatchesRouting() {
    routing {
        post("$apiPath/batches") {
            val batch = call.receive<Batch>()
            transaction {
                BatchEntity.new {
                    this.shiftID = batch.id
                    this.pelmeniType = batch.pelmeniType
                    this.pelmeniSize = batch.pelmeniSize
                    this.summaryMass = batch.summaryMass
                    this.created = batch.created.toInstant(ZoneOffset.UTC)
                    this.factoryID = batch.factoryID
                    this.packageTime = batch.packageTime?.toInstant(ZoneOffset.UTC)
                    this.packsCount = batch.packsCount
                    this.massOfDefective = batch.massOfDefective
                }
            }
        }

        get("$apiPath/batches/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw BadRequestException("bad id")
            call.respond(BatchEntity[id])
        }

        delete("$apiPath/batches/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
            transaction {
                BatchEntity[id].delete()
            }
        }

        get("$apiPath/batches") {
            val shiftID = call.request.queryParameters["shift_id"]?.toIntOrNull()
            val pelmeniType = call.request.queryParameters["pelmeni_type"]?.toIntOrNull()
            val pelmeniSize = call.request.queryParameters["pelmeni_size"]
            val createdBefore = try {
                Instant.parse(call.request.queryParameters["created_before"])
            } catch (e: NullPointerException) {
                null
            }
            val createdAfter = try {
                Instant.parse(call.request.queryParameters["created_after"])
            } catch (e: NullPointerException) {
                null
            }
            val factoryID = call.request.queryParameters["factory_id"]?.toIntOrNull()

            val packageTimeBefore = try {
                Instant.parse(call.request.queryParameters["package_time_before"])
            } catch (e: NullPointerException) {
                null
            }

            val packageTimeAfter = try {
                Instant.parse(call.request.queryParameters["package_time_after"])
            } catch (e: NullPointerException) {
                null
            }

            var batches : MutableList<ResultRow> = mutableListOf()
            transaction {
                batches = Batches.select {
                    (Batches.shiftID eq shiftID) and
                            (Batches.pelmeniType eq pelmeniType) and
                            (Batches.pelmeniSize eq pelmeniSize) and
                            //(Batches.created less (createdBefore ?: Instant.MAX)) and
                            //(Batches.created greater (createdAfter ?: Instant.MIN)) and
                            (Batches.factoryID eq factoryID) //and
                            //(Batches.packageTime less (packageTimeBefore ?: Instant.MAX)) and
                            //(Batches.packageTime greater (packageTimeAfter ?: Instant.MAX))
                }.toMutableList()

            }

            call.respond(batches)
        }
    }
}