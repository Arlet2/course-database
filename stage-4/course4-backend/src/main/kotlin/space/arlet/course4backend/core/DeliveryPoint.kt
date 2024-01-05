package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "delivery_points")
data class DeliveryPoint(
    @Id val id: Int? = null,
    val address: String? = null,
    @ManyToOne
    val pointType: DeliveryPointType? = null,
    val packsCapacity: Int? = null,
)