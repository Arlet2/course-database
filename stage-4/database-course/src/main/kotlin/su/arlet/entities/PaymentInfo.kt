package su.arlet.entities

import org.jetbrains.exposed.sql.Table

data class PaymentInfo(
    val id: Int,
    val salary: Double,
    val bankName: String,
    val accountNumber: String,
    val bik: String,
    val corrAccount: String,
    val inn: String,
    val kpp: String,
)

object PaymentsInfo : Table("payments_info") {
    val id = integer("id").autoIncrement()
    val salary = double("salary")
    val bankName = varchar("bank_name", 100)
    val accountNumber = varchar("account_number", 50)
    val bik = varchar("bik", 50)
    val corrAccount = varchar("corr_account", 50)
    val inn = varchar("inn", 50)
    val kpp = varchar("kpp", 50)

    override val primaryKey = PrimaryKey(id)
}