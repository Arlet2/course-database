package space.arlet.course4backend.core

import jakarta.persistence.*

@Entity
@Table(name = "batch_deliveries")
data class BatchDelivery(
    @ManyToOne
    @Id
    val delivery: Delivery? = null,
    @ManyToOne
    @Id
    val batch: Batch? = null,
    val amount: Int? = null,
    val mass: Double? = null,
)