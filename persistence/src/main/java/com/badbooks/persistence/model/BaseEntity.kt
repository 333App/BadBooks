package com.badbooks.persistence.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
open class BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    open var id: UUID? = null
        get() = field

    @Temporal(TemporalType.TIMESTAMP)
    open var createdDate: LocalDateTime = LocalDateTime.now()
        get() = field

    @Temporal(TemporalType.TIMESTAMP)
    open var updatedDate: LocalDateTime = LocalDateTime.now()
        get() = field
        set(value) {
            field = value
        }

    open var createdBy: UUID? = null
        get() = field

    open var updatedBy: UUID? = null
        get() = field
        set(value) {
            field = value
        }

    constructor() {
        this.id = null
        this.createdDate = LocalDateTime.now()
        this.updatedDate = LocalDateTime.now()
        this.createdBy = null
        this.updatedBy = null
    }

    constructor(
        id  : UUID,
        createdDate: LocalDateTime,
        updatedDate: LocalDateTime,
        createdBy: UUID,
        updatedBy: UUID
    ){
        this.id = id
        this.createdDate = createdDate
        this.updatedDate = updatedDate
        this.createdBy = createdBy
        this.updatedBy = updatedBy
    }

}
