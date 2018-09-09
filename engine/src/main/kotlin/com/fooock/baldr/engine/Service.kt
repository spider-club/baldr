package com.fooock.baldr.engine

/**
 * Base class for all services
 */
interface Service<T> {
    /**
     *
     */
    fun register(service: T)

    /**
     *
     */
    fun unregister(id: String)

    /**
     *
     */
    fun size(): Int

    /**
     *
     */
    fun get(id: String): T?
}
