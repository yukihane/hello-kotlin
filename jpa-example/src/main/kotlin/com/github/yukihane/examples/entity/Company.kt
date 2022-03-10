package com.github.yukihane.examples.entity

import javax.persistence.*


@Entity
class Company(
    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = [CascadeType.ALL])
    var branches: MutableSet<Branch> = mutableSetOf(),
) {
    fun addBranch(branch: Branch) {
        branches.add(branch)
        branch.company = this
    }
}
