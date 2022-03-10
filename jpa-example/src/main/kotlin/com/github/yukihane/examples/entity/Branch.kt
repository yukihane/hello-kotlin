package com.github.yukihane.examples.entity

import javax.persistence.*


@Entity
class Branch(
    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    var company: Company? = null,
)
