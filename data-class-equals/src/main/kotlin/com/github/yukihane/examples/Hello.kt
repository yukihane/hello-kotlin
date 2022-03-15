package com.github.yukihane.examples

class Person(val name: String) {
    val id: Int? = null
}

data class DataPerson(val name: String) {
    val id: Int? = null
}

fun main(args: Array<String>) {

    val p1 = Person("dewa")
    val p2 = Person("dewa")

    val dp1 = DataPerson("dewa")
    val dp2 = DataPerson("dewa")

    println(p1 == p2) // false
    println(dp1 == dp2) // true

}

