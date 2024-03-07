package com.badbooks.persistence.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "authors")
data class Author(

    val firstName: String,

    val lastName: String,

    val normalizedAuthorFullName: String,

    @ManyToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val books: List<Book>

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.firstName,
        builder.lastName,
        builder.normalizedAuthorFullName,
        builder.books

    ) {
        super.id = builder.id
        super.createdDate = builder.createdDate
        super.updatedDate = builder.updatedDate
        super.createdBy = builder.createdBy
        super.updatedBy = builder.updatedBy
    }

    constructor() : this(Builder())

    class Builder {
        var id: UUID = UUID.randomUUID()
            private set

        var firstName: String = ""
            private set

        var lastName: String = ""
            private set

        var normalizedAuthorFullName: String = ""
            private set

        var books: List<Book> = ArrayList<Book>()
            private set
        var createdDate: LocalDateTime = LocalDateTime.now()
            private set

        var updatedDate: LocalDateTime = LocalDateTime.now()
            private set

        var createdBy: UUID? = null
            private set

        var updatedBy: UUID? = null
            private set

        fun id(id: UUID) = apply { this.id = id }

        fun firstName(firstName: String) = apply { this.firstName = firstName }

        fun lastName(lastName: String) = apply { this.lastName = lastName }

        fun normalizedAuthorFullName(normalizedAuthorFullName: String) =
            apply { this.normalizedAuthorFullName = normalizedAuthorFullName }

        fun books(books: List<Book>) = apply { this.books = books }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }
        fun build() = Author(this)
    }
}
