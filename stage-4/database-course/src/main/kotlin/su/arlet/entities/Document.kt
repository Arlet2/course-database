package su.arlet.entities

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

data class Document(
    val id: Int,
    val name: String,
    val dataURL: String,
    val ownerID: Int?,
    val signed: Boolean?
)

class DocumentEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, DocumentEntity>(Documents)

    var name by Documents.name
    var dataURL by Documents.dataURL
    var ownerID by Documents.ownerID
    var signed by Documents.signed
}

object Documents : IdTable<Int>("documents") {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
    val name = varchar("name", 100)
    val dataURL = text("data_url")
    val ownerID = integer("owner_id")
        .references(Employees.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val signed = bool("signed").nullable()

    override val primaryKey = PrimaryKey(id)
}