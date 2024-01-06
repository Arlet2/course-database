package space.arlet.course4backend.core

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "deliveries")
data class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int?,
    @ManyToOne
    val transport: Transport?,
    @ManyToOne
    val deliveryPoint: DeliveryPoint?,
    val packsCount: Int?,
    @ManyToOne
    val factory: Factory,
    val departureDate: LocalDateTime?,
    val arrivalDate: LocalDateTime?,
)