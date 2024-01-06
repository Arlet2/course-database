package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "conveyors")
data class Conveyor(
    @Id val id: Int,
    @ManyToOne
    val manager: Employee,
    val name: String?,
    val commissioningDate: LocalDate?,
    @ManyToOne
    val factory: Factory?,
    val decommissioningDate: LocalDate?,
)