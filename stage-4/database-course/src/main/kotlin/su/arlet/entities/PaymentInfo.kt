package su.arlet.entities

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

data class PaymentInfo(
    val id: Int,
    val salary: Int,
    val bankName: String,
    val accountNumber: String,
    val bik: String?,
    val corrAccount: String?,
    val inn: String?,
    val kpp: String?,
)

class PaymentInfoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, PaymentInfoEntity>(PaymentsInfo)

    var salary by PaymentsInfo.salary
    var bankName by PaymentsInfo.bankName
    var accountNumber by PaymentsInfo.accountNumber
    var bik by PaymentsInfo.bik
    var corrAccount by PaymentsInfo.corrAccount
    var inn by PaymentsInfo.inn
    var kpp by PaymentsInfo.kpp
}

object PaymentsInfo : IdTable<Int>("payments_info") {
    override val id : Column<EntityID<Int>> = integer("id").autoIncrement().entityId()
    val salary = integer("salary").check("positive_salary") { it.greaterEq(0) }
    val bankName = varchar("bank_name", 100)
    val accountNumber = varchar("account_number", 50)
    val bik = varchar("bik", 50).nullable()
    val corrAccount = varchar("corr_account", 50).nullable()
    val inn = varchar("inn", 50).nullable()
    val kpp = varchar("kpp", 50).nullable()

    override val primaryKey = PrimaryKey(id)
}