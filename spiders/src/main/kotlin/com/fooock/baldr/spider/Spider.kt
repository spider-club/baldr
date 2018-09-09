package com.fooock.baldr.spider

import com.fooock.baldr.network.Request
import com.fooock.baldr.network.Response

/**
 * Base class for all spiders
 */
abstract class Spider(val name: String) {
    var spiderProcessor: SpiderProcessor? = null

    /**
     * Initial url's for this Spider to be crawled
     */
    abstract val startUrls: Array<String>

    /**
     * Array of allowed domains to be crawled by this spider.
     */
    open val allowedDomains: Array<String> = emptyArray()

    override fun toString(): String = name

    /**
     *
     */
    abstract fun parse(response: Response)

    /**
     *
     */
    protected fun yield(request: Request? = null, item: Item? = null) {
        if (request != null) spiderProcessor?.process(request)
    }

    /**
     *
     */
    fun process() = startUrls.forEach { yield(Request(it)) }
}
