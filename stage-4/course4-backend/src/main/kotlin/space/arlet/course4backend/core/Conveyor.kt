package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "conveyors")
data class Conveyor(
    @Id val id: Int? = null,
    @ManyToOne
    val manager: Employee? = null,
    val name: String? = null,
    val commissioningDate: LocalDate? = null,
    val decommissioningDate: LocalDate? = null,
)