package ch02

import org.w3c.dom.css.Rect

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}