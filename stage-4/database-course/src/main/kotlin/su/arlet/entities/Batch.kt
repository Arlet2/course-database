package su.arlet.entities

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import java.time.LocalDateTime

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.greaterEq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.isNull
import org.jetbrains.exposed.sql.javatime.timestamp
import su.arlet.entities.Batches.autoIncrement
import su.arlet.entities.Batches.check
import su.arlet.entities.Batches.nullable
import su.arlet.entities.Batches.references


data class Batch(
    val id: Int,
    val shiftID: Int?,
    val pelmeniType: Int?,
    val pelmeniSize: String?,
    val summaryMass: Double,
    val created: LocalDateTime,
    val factoryID: Int?,
    val packageTime: LocalDateTime?,
    val packsCount: Int?,
    val massOfDefective: Double?
)

class BatchEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, BatchEntity>(Batches)

    var shiftID by Batches.shiftID
    var pelmeniType by Batches.pelmeniType
    var pelmeniSize by Batches.pelmeniSize
    var summaryMass by Batches.summaryMass
    var created by Batches.created
    var factoryID by Batches.factoryID
    var packageTime by Batches.packageTime
    var packsCount by Batches.packsCount
    var massOfDefective by Batches.massOfDefective
}

object Batches : IdTable<Int>("batches") {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
    val shiftID = integer("shift_id")
        .references(WorkShifts.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val pelmeniType = integer("pelmeni_type")
        .references(PelmeniTypes.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val pelmeniSize = varchar("pelmeni_size", 255)
        .references(PelmeniSizes.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val summaryMass = double("summary_mass").check("positive_mass") { it.greaterEq(0.0) }
    val created = timestamp("created")
    val factoryID = integer("factory_id")
        .references(Factories.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val packageTime = timestamp("package_time").nullable()
        .check("after_created") { it.isNull().or(it.greaterEq(created)) }
    val packsCount = integer("packs_count").nullable()
        .check("positive_count") { it.isNull().or(it.greaterEq(0)) }
    val massOfDefective = double("mass_of_defective").nullable()
        .check("positive_defective_mass") { it.isNull().or(it.greaterEq(0.0)) }

    override val primaryKey = PrimaryKey(id)
}
