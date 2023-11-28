package su.arlet.entities

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

object FreezingInfo : Table("freezing_info") {
    val batchID = integer("batch_id")
        .references(Batches.id, onDelete = ReferenceOption.CASCADE)
    val sectionID = integer("section_id")
        .references(Sections.id, onDelete = ReferenceOption.CASCADE)
    val temperature = double("temperature")
    val loadDate = date("load_date")
    val uploadDate = date("upload_date").nullable()
        .check("after_load") { it.isNull().or(it.greaterEq(loadDate)) }

    override val primaryKey = PrimaryKey(batchID, sectionID)
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




















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































