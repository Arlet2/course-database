package su.arlet.entities

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.LocalDateTime


data class Delivery(
    val id: Int,
    val transportNumber: String?,
    val deliveryPointID: Int?,
    val packsCount: Int?,
    val factoryID: Int?,
    val departureDate: LocalDateTime?,
    val arrivalDate: LocalDateTime?
)

class DeliveryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, DeliveryEntity>(Deliveries)

    var transportNumber by Deliveries.transportNumber
    var deliveryPointID by Deliveries.deliveryPointID
    var packsCount by Deliveries.packsCount
    var factoryID by Deliveries.factoryID
    var departureDate by Deliveries.departureDate
    var arrivalDate by Deliveries.arrivalDate
}

object Deliveries : IdTable<Int>("deliveries") {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
    val transportNumber = varchar("transport_number", 10)
        .references(Transports.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val deliveryPointID = integer("delivery_point_id")
        .references(DeliveryPoints.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val packsCount = integer("packs_count").nullable()
        .check("positive_count") { it.isNull().or(it.greaterEq(0)) }
    val factoryID = integer("factory_id")
        .references(Factories.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val departureDate = timestamp("departure_date").nullable()
    val arrivalDate = timestamp("arrival_date").nullable()
        .check("after_departure") {
            it.isNull().or(departureDate.isNull()).or(it.greaterEq(departureDate))
        }

    override val primaryKey = PrimaryKey(id)
}

// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .





































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































