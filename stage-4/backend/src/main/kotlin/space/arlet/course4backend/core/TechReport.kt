package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tech_reports")
data class TechReport(
    @Id val id: Int,
    @ManyToOne
    val reporter: Employee,
    @ManyToOne
    val shift: WorkShift,
    val state: Int,
    val created: LocalDateTime?,
    val description: String?,
)