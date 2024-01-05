package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "factories")
data class Factory(
    @Id val id: Int? = null,
    val address: String? = null,
)