package space.arlet.course4backend.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "documents")
data class Document(
    @Id val id: Int,
    val name: String,
    val dataURL: String,
    @ManyToOne
    val owner: Employee?,
    val signed: Boolean?,
)