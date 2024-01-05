package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "work_shifts")
data class WorkShift(
    @Id val id: Int? = null,
    @OneToOne
    val batch: Batch? = null,
    @OneToOne
    val conveyor: Conveyor? = null,
    val timeStart: LocalDateTime? = null,
    val timeEnd: LocalDateTime? = null,
)