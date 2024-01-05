package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "documents")
data class Document(
    @Id val id: Int? = null,
    val name: String? = null,
    val dataURL: String? = null,
    @ManyToOne
    val owner: Employee? = null,
    val signed: Boolean? = null,
)