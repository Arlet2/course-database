package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "transports")
data class Transport(
    @Id val transportNumber: String? = null,
    val packsCapacity: Int? = null,
    val maxWeight: Double? = null,
)