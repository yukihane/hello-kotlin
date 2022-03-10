package com.github.yukihane.examples.entity

import javax.persistence.*


@Entity
class Company(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    var branches: MutableSet<Branch> = mutableSetOf(),
)
