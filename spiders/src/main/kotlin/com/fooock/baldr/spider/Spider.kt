package com.fooock.baldr.spider

import com.fooock.baldr.network.Response

/**
 * Base class for all spiders
 */
abstract class Spider(val name: String) {
    /**
     * Initial url's for this Spider to be crawled
     */
    abstract val startUrls: Array<String>

    /**
     * Array of allowed domains to be crawled by this spider.
     */
    open val allowedDomains: Array<String> = emptyArray()

    override fun toString(): String {
        return name
    }

    abstract fun parse(response: Response): Result
}
