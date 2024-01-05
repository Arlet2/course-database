package space.arlet.course4backend.core

import jakarta.persistence.*

@Entity
@Table(name = "batch_deliveries")
data class BatchDelivery(
    @ManyToOne
    @Id
    val delivery: Delivery,
    @ManyToOne
    @Id
    val batch: Batch,
    val amount: Int,
    val mass: Double?,
)