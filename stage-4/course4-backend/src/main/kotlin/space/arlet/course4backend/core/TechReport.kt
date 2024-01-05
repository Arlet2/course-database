package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tech_reports")
data class TechReport(
    @Id val id: Int? = null,
    @ManyToOne
    val reporter: Employee? = null,
    @ManyToOne
    val shift: WorkShift? = null,
    val state: Int? = null,
    val created: LocalDateTime? = null,
    val description: String? = null,
)