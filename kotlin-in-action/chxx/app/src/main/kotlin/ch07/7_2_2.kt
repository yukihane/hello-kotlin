package ch07

// Comparable を実装しなくても、 operator で compareTo を定義しておけば < をオーバロードできる
class Person(val firstName: String, val lastName: String) {
    operator fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }

}

fun main() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
}
