package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "freezings_info")
data class FreezingInfoObject(
    @Id
    @ManyToOne
    val batch: Batch? = null,
    @Id
    @ManyToOne
    val section: Section? = null,
    val temperature: Double? = null,
    val loadDate: LocalDate? = null,
    val uploadDate: LocalDate? = null,
)