package com.github.yukihane.examples.userType

import org.hibernate.usertype.UserType
import java.io.Serializable

/**
 * 単一カラムにマップされる、イミュータブルな型のための [UserType] 実装。
 * [High-Performance Java Persistence](https://vladmihalcea.com/books/high-performance-java-persistence/)
 * 記載のJava実装を元にしています。
 */
abstract class ImmutableType<T : Serializable>(
    private val clazz: Class<T>,
) : UserType {
    override fun equals(x: Any?, y: Any?): Boolean = (x == y)

    override fun hashCode(x: Any?): Int = x.hashCode()

    override fun returnedClass(): Class<*> = clazz


    override fun deepCopy(value: Any?): Any? = value

    override fun isMutable(): Boolean = false

    override fun disassemble(value: Any?): Serializable? = value as T?

    override fun assemble(cached: Serializable?, owner: Any): Any? = cached

    override fun replace(original: Any?, target: Any?, owner: Any): Any? = original

}
