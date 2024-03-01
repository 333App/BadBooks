package com.badbooks.persistence.model

import java.time.LocalDateTime
import java.util.*

data class BookImage(

    var thumbnail: String?,

    var smallThumbnail: String?,

    var small: String?,

    var medium: String?,

    var large: String?,

    var extreLarge: String?,

    var book: Book?

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.thumbnail,
        builder.smallThumbnail,
        builder.small,
        builder.medium,
        builder.large,
        builder.extreLarge,
        null
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

        var thumbnail: String? = ""
            private set

        var smallThumbnail: String? = ""
            private set

        var small: String? = ""
            private set

        var medium: String? = ""
            private set

        var large: String? = ""
            private set

        var extreLarge: String? = ""
            private set

        var book: Book? = null
            private set

        var createdDate: LocalDateTime = LocalDateTime.now()
            private set

        var updatedDate: LocalDateTime = LocalDateTime.now()
            private set

        var createdBy: UUID? = null
            private set

        var updatedBy: UUID? = null
            private set

        fun thumbnail(thumbnail: String) = apply { this.thumbnail = thumbnail }

        fun smallThumbnail(smallThumbnail: String?) = apply { this.smallThumbnail = smallThumbnail }

        fun small(small: String?) = apply { this.small = small }

        fun medium(medium: String?) = apply { this.medium = medium }

        fun large(large: String?) = apply { this.large = large }

        fun extraLarge(extreLarge: String?) = apply { this.extreLarge = extreLarge }

        fun book(book: Book?) = apply { this.book = book }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }
        fun build() = BookImage(this)
    }
}
