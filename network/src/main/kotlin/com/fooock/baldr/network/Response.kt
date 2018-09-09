package com.fooock.baldr.network

import mu.KotlinLogging
import okhttp3.Response
import org.jsoup.Jsoup
import org.jsoup.select.Elements

/**
 *
 */
class Response(private val response: Response) {
    private val logger = KotlinLogging.logger {}

    /**
     * Retrieve all links from this response object
     */
    fun links(): Array<Request> {
        return links("")
    }

    /**
     *
     */
    fun links(query: String): Array<Request> {
        val elements: Elements = document().select("${query.trim()} a[href]")
        val requests: MutableList<Request> = ArrayList()
        for (element in elements) {
            val href = element.attr("href")
            val link = response.request().url().resolve(href) ?: continue
            requests.add(Request(link.url().toString()))
        }
        logger.info { "Found ${requests.size} links from ${response.request().url()}" }
        return requests.toTypedArray()
    }

    /**
     *
     */
    fun css(query: String): Elements = document().select(query)

    /**
     *
     */
    fun title(): String = document().title()

    private fun document() = Jsoup.parse(response.body()?.string(), response.request()?.url().toString())
}
