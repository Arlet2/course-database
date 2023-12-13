package su.arlet.entities

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate


data class FreezingInfoObject (
    val batchID: Int,
    val sectionID: Int,
    val temperature: Double,
    val loadDate: LocalDate,
    val uploadDate: LocalDate?
)

//class FreezingInfoEntity(id: EntityID<Int>) : IntEntity(id) {
//    companion object : EntityClass<Int, FreezingInfoEntity>(FreezingInfo)
//
//    var transportNumber by Deliveries.transportNumber
//    var deliveryPointID by Deliveries.deliveryPointID
//    var packsCount by Deliveries.packsCount
//    var factoryID by Deliveries.packsCount
//    var departureDate by Deliveries.departureDate
//    var arrivalDate by Deliveries.arrivalDate
//}

//object FreezingInfo : IdTable<Int, Int>("freezing_info") {
//    val batchID = integer("batch_id")
//        .references(Batches.id, onDelete = ReferenceOption.CASCADE)
//    val sectionID = integer("section_id")
//        .references(Sections.id, onDelete = ReferenceOption.CASCADE)
//    val temperature = double("temperature")
//    val loadDate = date("load_date")
//    val uploadDate = date("upload_date").nullable()
//        .check("after_load") { it.isNull().or(it.greaterEq(loadDate)) }
//
//    override val primaryKey = PrimaryKey(batchID, sectionID)
//}

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





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































