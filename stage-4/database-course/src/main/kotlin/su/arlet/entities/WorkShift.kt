package su.arlet.entities

import java.time.LocalDateTime

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.timestamp


data class WorkShift(
    val id: Int,
    val batchID: Int?,
    val conveyorID: Int?,
    val timeStart: LocalDateTime?,
    val timeEnd: LocalDateTime?
)

object WorkShifts : Table("work_shifts") {
    val id = integer("id").autoIncrement()
    val batchID = integer("batch_id")
        .references(Batches.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val conveyorID = integer("conveyor_id")
        .references(Conveyors.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val timeStart = timestamp("time_start").nullable()
    val timeEnd = timestamp("time_end").nullable()
        .check("after_start") {
            it.isNull().or(timeStart.isNull()).or(it.greaterEq(timeStart))
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
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .
// .
//  .
//   .
//    .
//     .
//      .
//     .
//    .
//   .
//  .











































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































