package su.arlet.entities

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

data class Document(
    val id: Int,
    val name: String,
    val dataURL: String,
    val ownerID: Int?,
    val signed: Boolean?
)

object Documents : Table("documents") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100)
    val dataURL = text("data_url")
    val ownerID = integer("owner_id")
        .references(Employees.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val signed = bool("signed").nullable()

    override val primaryKey = PrimaryKey(id)
}