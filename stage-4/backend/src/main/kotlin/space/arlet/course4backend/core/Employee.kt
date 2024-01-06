package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employees")
data class Employee(
    @Id val id: Int,
    val fullName: String,
    val jobTitle: String?,
    val employmentDate: LocalDate,
    val dismissalDate: LocalDate?,
    @OneToMany
    val paymentInfo: List<PaymentInfo>?,
    @OneToMany
    val agreement: List<Document>?,
)