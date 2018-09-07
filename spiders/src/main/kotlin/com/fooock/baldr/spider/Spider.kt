package com.fooock.baldr.spider

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
}
