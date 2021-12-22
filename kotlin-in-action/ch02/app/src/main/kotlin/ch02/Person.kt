package ch02

class Person(val name: String, var isMarried: Boolean)

fun main() {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

    val personJava = PersonJava("Charlie", false)
    println(personJava.name)
    println(personJava.isMarried)
}
