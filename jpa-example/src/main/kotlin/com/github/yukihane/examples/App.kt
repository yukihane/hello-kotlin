package com.github.yukihane.examples

import com.github.yukihane.examples.entity.Branch
import com.github.yukihane.examples.entity.Company
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence


fun main() {
    val emf = Persistence.createEntityManagerFactory("myunit")

    create(emf)
    read(emf)
}

fun create(emf: EntityManagerFactory) {
    val em = emf.createEntityManager()
    val c = Company(name = "my company")

    val b1 = Branch(name = "branch1")
    val b2 = Branch(name = "branch2")

    c.addBranch(b1)
    c.addBranch(b2)

    val tx = em.transaction
    tx.begin()
    em.persist(c)
    tx.commit()
    em.close()
}


fun read(emf: EntityManagerFactory) {
    val em = emf.createEntityManager()
    val q = em.createQuery("select c from Company c")
    val res = q.resultList as List<Company>
    res.map {
        println("company: ${it.name}")
        it.branches.map { b -> println("branch: ${b.name}") }
    }
}
