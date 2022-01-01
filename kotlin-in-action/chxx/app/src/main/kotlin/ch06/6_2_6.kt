package ch06

// Nothing を外すと Unit 型として宣言される
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    // Nothing でも警告に留まっている
    val result = fail("Error occurred")
}
