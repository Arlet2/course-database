package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "deliveries")
data class Delivery(
    @Id val id: Int,
    val transportNumber: String?,
    @ManyToOne
    val deliveryPoint: DeliveryPoint?,
    val packsCount: Int?,
    @ManyToOne
    val factory: Factory,
    val departureDate: LocalDateTime?,
    val arrivalDate: LocalDateTime?,
)