package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "batches")
data class Batch(
    @Id val id: Int? = null,
    @OneToOne
    val shift: WorkShift? = null,
    val pelmeniType: Int? = null,
    val pelmeniSize: String? = null,
    val summaryMass: Double? = null,
    val created: LocalDateTime? = null,
    @ManyToOne
    val factory: Factory? = null,
    val packageTime: LocalDateTime? = null,
    val packsCount: Int? = null,
    val massOfDefective: Double? = null,
)