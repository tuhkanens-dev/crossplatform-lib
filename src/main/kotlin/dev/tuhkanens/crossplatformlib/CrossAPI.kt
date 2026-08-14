package dev.tuhkanens.crossplatformlib

import java.util.concurrent.ConcurrentHashMap

object CrossAPI {

    @PublishedApi
    internal val registry: ConcurrentHashMap<Class<*>, Any> = ConcurrentHashMap()

    inline fun <reified T : Any> register(implementation: Any) {
        registry[T::class.java] = implementation
    }

    inline fun <reified T : Any> get(): T {
        val implementation = registry[T::class.java]
            ?: throw IllegalStateException("API '${T::class.java}' is not registered")
        return implementation as T
    }

}