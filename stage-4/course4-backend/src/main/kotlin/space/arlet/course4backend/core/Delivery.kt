package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "deliveries")
data class Delivery(
    @Id val id: Int? = null,
    val transportNumber: String? = null,
    @ManyToOne
    val deliveryPoint: DeliveryPoint? = null,
    val packsCount: Int? = null,
    val factoryID: Int? = null,
    val departureDate: LocalDateTime? = null,
    val arrivalDate: LocalDateTime? = null,
)