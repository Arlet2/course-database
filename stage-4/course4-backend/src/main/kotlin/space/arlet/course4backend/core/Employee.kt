package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employees")
data class Employee(
    @Id val id: Int? = null,
    val fullName: String? = null,
    val jobTitle: String? = null,
    val employmentDate: LocalDate? = null,
    val dismissalDate: LocalDate? = null,
    @OneToMany
    val paymentInfo: List<PaymentInfo>? = null,
    @OneToMany
    val agreement: List<Document>? = null,
)