package ch05

class Person(val name: String, val age:Int)

fun sendEmail(person: Person, message: String){}

fun main() {
    val people = listOf(Person("Alice",29),Person("Bob",31))
    val names = people.joinToString(separator=" ") { p: Person -> p.name }
    println(names)

    val action = {person: Person, message: String -> sendEmail(person,message)}
    val nextAction = ::sendEmail
}
