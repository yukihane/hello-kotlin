/*
 * This source file was generated by the Gradle 'init' task
 */
package com.example

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration

object App {
    @JvmStatic
    fun create(): Duration {
        return 10.hours + 30.minutes
    }

    @JvmStatic
    fun createJava(): java.time.Duration {
        return create().toJavaDuration()
    }
}
