package su.arlet.entities

import org.jetbrains.exposed.sql.Table

data class Document(
    val id: Int,
    val name: String,
    val dataURL: String,
    val ownerID: Int,
    val signed: Boolean,
)

object Documents : Table("documents") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100)
    val dataURL = varchar("data_url", 256)
    val ownerID = integer("owner_id")
    val signed = bool("signed")

    override val primaryKey = PrimaryKey(id)
}