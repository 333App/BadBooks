package com.badbooks.persistence.model

import java.time.LocalDateTime
import java.util.*

data class BookCategory(

    var categoryName: String,

    var parentCategory: BookCategory?,

    var subCategory: List<BookCategory>


) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.categoryName,
        builder.parentCategory,
        builder.subCategory

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
        var categoryName: String = ""
            private set

        var parentCategory: BookCategory? = null
            private set
        var subCategory: List<BookCategory> = ArrayList<BookCategory>()
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

        fun categoryName(categoryName: String) = apply { this.categoryName = categoryName }

        fun parentCategory(parentCategory: BookCategory?) = apply { this.parentCategory = parentCategory }

        fun subCategory(subCategory: List<BookCategory>) = apply { this.subCategory = subCategory }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }
        fun build() = BookCategory(this)
    }
}
