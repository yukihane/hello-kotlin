fun main() {
    val p1 = Person1().apply {
        name = "Alice"
    }

    val p2 = Person2().apply {
        name = "Bob" // Val cannot be reassigned
        // workaround: setName("Bob")
    }

    val p3 = Person3().apply {
        name = "Charlie"
    }
}

class Person3 : IPerson {
    override var name: String? = null
}
