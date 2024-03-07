package com.badbooks.persistence.model

import com.badbooks.persistence.enumaration.Roles
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
data class User(

    val userName: String,

    val email: String,

    val userPassword: String,

    @Enumerated(EnumType.STRING)
    val userRole: Roles,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_followers",
        joinColumns = [JoinColumn(name = "following_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "followers_id", referencedColumnName = "id")]
    )
    val followers: List<User>,

    @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val following: List<User>,

    @ManyToMany(mappedBy = "favoritesByUser", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val book: List<Book>?,

    val isAccountNonExpired: Boolean,

    val isAccountNonLocked: Boolean,

    val isCredentialsNonExpired: Boolean,

    val isEnabled: Boolean

) : BaseEntity() {

    constructor(builder: Builder) : this(
        builder.userName,
        builder.email,
        builder.userPassword,
        builder.userRole,
        builder.followers,
        builder.following,
        builder.book,
        builder.isAccountNonExpired,
        builder.isAccountNonLocked,
        builder.isCredentialsNonExpired,
        builder.isEnabled
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

        var userName: String = ""
            private set

        var email: String = ""
            private set

        var userPassword: String = ""
            private set

        var userRole: Roles = Roles.USER
            private set

        var followers: List<User> = ArrayList<User>()
            private set

        var following: List<User> = ArrayList<User>()
            private set

        var book: List<Book>? = null
            private set
        var createdDate: LocalDateTime = LocalDateTime.now()
            private set

        var updatedDate: LocalDateTime = LocalDateTime.now()
            private set

        var createdBy: UUID? = null
            private set

        var updatedBy: UUID? = null
            private set

        var isAccountNonExpired: Boolean = false
            private set

        var isAccountNonLocked: Boolean = false
            private set

        var isCredentialsNonExpired: Boolean = false
            private set

        var isEnabled: Boolean = false
            private set

        fun id(id: UUID) = apply { this.id = id }
        fun userName(userName: String) = apply { this.userName = userName }
        fun email(email: String) = apply { this.email = email }
        fun userPassword(userPassword: String) = apply { this.userPassword = userPassword }

        fun userRole(userRole: Roles) = apply { this.userRole = userRole }

        fun followers(followers: List<User>) = apply { this.followers = followers }

        fun following(following: List<User>) = apply { this.following = following }

        fun book(book: List<Book>) = apply { this.book = book }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updatedDate(updatedDate: LocalDateTime) = apply { this.updatedDate = updatedDate }
        fun createdBy(createdBy: UUID) = apply { this.createdBy = createdBy }
        fun updatedBy(updatedBy: UUID) = apply { this.updatedBy = updatedBy }

        fun isAccountNonExpired(isAccountNonExpired: Boolean) = apply { this.isAccountNonExpired = isAccountNonExpired }
        fun isAccountNonLocked(isAccountNonLocked: Boolean) = apply { this.isAccountNonLocked = isAccountNonLocked }
        fun isCredentialsNonExpired(isCredentialsNonExpired: Boolean) =
            apply { this.isCredentialsNonExpired = isCredentialsNonExpired }

        fun isEnabled(isEnabled: Boolean) = apply { this.isEnabled = isEnabled }
        fun build() = User(this)
    }
}