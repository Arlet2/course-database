package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "sections")
data class Section(
    @Id val id: Int? = null,
    val size: Int? = null,
)