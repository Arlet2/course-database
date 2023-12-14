package su.arlet.entities

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
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

class EmployeeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, EmployeeEntity>(Employees)

    var fullName by Employees.fullName
    var jobTitle by Employees.jobTitle
    var employmentDate by Employees.employmentDate
    var dismissalDate by Employees.dismissalDate
    var paymentID by Employees.paymentID
    var agreementID by Employees.agreementID
}

object Employees : IdTable<Int>("employees") {
    override val id : Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
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

