package com.badbooks.persistence.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.List

@Entity
@Table(name = "books")
data class Book(

    val title: String,

    val description: String?,

    val publisher: String?,

    val pageCount: Short?,

    val bookSaleLink: String?,

    val bookPdfLink: String?,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "author_books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "author_id", referencedColumnName = "id")]
    )
    val author: List<Author>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "category_books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "book-category_id", referencedColumnName = "id")]
    )
    val bookCategory: List<BookCategory>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    val favoritesByUser: List<User>,

    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    val bookImage: BookImage?

) : BaseEntity() {
    constructor(builder: Builder) : this(
        builder.title,
        builder.description,
        builder.publisher,
        builder.pageCount,
        builder.bookSaleLink,
        builder.bookPdfLink,
        builder.author,
        builder.bookCategory,
        builder.favoritesByUser,
        builder.bookImage
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

        var title: String = ""
            private set

        var description: String? = ""
            private set

        var publisher: String? = ""
            private set

        var pageCount: Short? = null
            private set

        var bookSaleLink: String? = ""
            private set

        var bookPdfLink: String? = ""
            private set

        var author: List<Author> = ArrayList<Author>()
            private set

        var bookCategory: List<BookCategory> = ArrayList<BookCategory>()
            private set

        var favoritesByUser: List<User> = ArrayList<User>()
            private set

        var bookImage: BookImage? = null
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

        fun title(title: String) = apply { this.title = title }

        fun description(description: String) = apply { this.description = description }

        fun publisher(publisher: String) = apply { this.publisher = publisher }
        fun pageCount(pageCount: Short) = apply { this.pageCount = pageCount }
        fun bookSaleLink(bookSaleLink: String) = apply { this.bookSaleLink = bookSaleLink }
        fun bookPdfLink(bookPdfLink: String?) = apply { this.bookPdfLink = bookPdfLink }

        fun author(author: List<Author>) = apply { this.author = author }

        fun bookCategory(bookCategory: List<BookCategory>) = apply { this.bookCategory = bookCategory }

        fun favoritesByUser(favoritesByUser: List<User>) = apply { this.favoritesByUser = favoritesByUser }

        fun bookImage(bookImage: BookImage) = apply { this.bookImage = bookImage }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }
        fun build() = Book(this)
    }
}