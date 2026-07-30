package dev.tuhkanens.crossplatformlib

import java.util.concurrent.ConcurrentHashMap

object CrossPlatformAPI {

    val registry: ConcurrentHashMap<Class<*>, Any> = ConcurrentHashMap()

    inline fun <reified T> registerAPI(implementation: Any) {
        registry[T::class.java] = implementation
    }

    inline fun <reified T> getAPI(): T {
        val implementation = registry[T::class.java]
            ?: throw IllegalStateException("API '${T::class.java.name}' is not registered")
        return implementation as T
    }

}