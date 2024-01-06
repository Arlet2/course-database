package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "delivery_points")
data class DeliveryPoint(
    @Id val id: Int,
    val address: String,
    @ManyToOne
    val pointType: DeliveryPointType?,
    val packsCapacity: Int,
)