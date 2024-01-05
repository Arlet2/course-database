package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "pelmeni_types")
data class PelmeniType(
    @Id val id: Int? = null,
    val name: String? = null,
    val recipe: String? = null,
)