package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "work_shifts")
data class WorkShift(
    @Id val id: Int,
    @OneToOne
    val batch: Batch,
    @OneToOne
    val conveyor: Conveyor,
    val timeStart: LocalDateTime?,
    val timeEnd: LocalDateTime?,
)