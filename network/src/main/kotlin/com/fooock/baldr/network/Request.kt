package com.fooock.baldr.network

/**
 *
 */
data class Request(private val url: String) {
    override fun toString(): String = url
}
