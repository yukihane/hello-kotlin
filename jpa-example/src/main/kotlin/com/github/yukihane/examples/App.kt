package com.github.yukihane.examples

import com.github.yukihane.examples.entity.Company
import javax.persistence.Persistence


fun main() {
    val emf = Persistence.createEntityManagerFactory("myunit")
    val em = emf.createEntityManager()
    val c = Company()
    val tx = em.transaction
    tx.begin()
    em.persist(c)
    tx.commit()
    em.close()
}
