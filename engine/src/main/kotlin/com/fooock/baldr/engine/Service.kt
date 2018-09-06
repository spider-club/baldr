package com.fooock.baldr.engine

/**
 * Base class for all services
 */
interface Service<in T> {
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
}
