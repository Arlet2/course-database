package su.arlet.entities

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.*


data class Factory(
    val id: Int,
    val address: String
)

class FactoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, FactoryEntity>(Factories)

    var address by Factories.address
}

object Factories : IdTable<Int>("factories") {
    override val id : Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
    val address = varchar("address", 255)

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






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































