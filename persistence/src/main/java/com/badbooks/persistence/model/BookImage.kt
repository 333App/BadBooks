package com.badbooks.persistence.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*
@Entity
@Table(name = "bookimages")
data class BookImage(

    val thumbnail: String?,

    val smallThumbnail: String?,

    val small: String?,

    val medium: String?,

    val large: String?,

    val extreLarge: String?,

    @OneToOne(fetch = FetchType.LAZY)
    val book: Book?

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

    constructor() : this(Builder())

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
