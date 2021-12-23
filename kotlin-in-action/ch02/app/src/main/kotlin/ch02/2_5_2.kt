import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)

    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map)
}