package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "payments_info")
data class PaymentInfo(
    @Id val id: Int? = null,
    val salary: Int? = null,
    val bankName: String? = null,
    val accountNumber: String? = null,
    val bik: String? = null,
    val corrAccount: String? = null,
    val inn: String? = null,
    val kpp: String? = null,
)