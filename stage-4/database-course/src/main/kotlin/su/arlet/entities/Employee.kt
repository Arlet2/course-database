package su.arlet.entities

import java.time.LocalDate

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.date

data class Employee(
    val id: Int,
    val fullName: String,
    val jobTitle: String?,
    val employmentDate: LocalDate,
    val dismissalDate: LocalDate?,
    val paymentID: Int?,
    val agreementID: Int?
)

object Employees : Table("employees") {
    val id = integer("id").autoIncrement()
    val fullName = varchar("full_name", 255)
    val jobTitle = varchar("job_title", 50).nullable()
    val employmentDate = date("employment_date")
    val dismissalDate = date("dismissal_date").nullable()
    val paymentID = integer("payment_id")
        .references(PaymentsInfo.id, onDelete = ReferenceOption.SET_NULL).nullable()
    val agreementID = integer("agreement_id")
        .references(Documents.id, onDelete = ReferenceOption.SET_NULL).nullable()

    override val primaryKey = PrimaryKey(id)
}

