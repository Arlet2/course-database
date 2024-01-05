package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "pelmeni_types")
data class PelmeniType(
    @Id val id: Int,
    val name: String,
    val recipe: String,
)