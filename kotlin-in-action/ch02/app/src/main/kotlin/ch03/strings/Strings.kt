package ch03.strings

fun String.lastChar(): Char = get(length - 1)

fun main() {
    val c = "Kotlin".lastChar()
    println(c)
}