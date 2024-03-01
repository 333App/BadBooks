package com.badbooks.persistence.model

import java.time.LocalDateTime
import java.util.*

data class Author(

    var firstName: String,

    var lastName: String,

    var normalizedAuthorFullName: String

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.firstName,
        builder.lastName,
        builder.normalizedAuthorFullName

    ) {
        super.id = builder.id
        super.createdDate = builder.createdDate
        super.updatedDate = builder.updatedDate
        super.createdBy = builder.createdBy
        super.updatedBy = builder.updatedBy
    }

    class Builder {
        var id: UUID = UUID.randomUUID()
            private set

        var firstName: String = ""
            private set

        var lastName: String = ""
            private set

        var normalizedAuthorFullName: String = ""
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

        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }
        fun build() = Author(this)
    }
}
