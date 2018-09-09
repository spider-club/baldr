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
     *
     */
    fun links(): Array<Request> {
        val document = Jsoup.parse(response.body()?.string(), response.request()?.url().toString())
        val elements: Elements = document.select("a[href]")
        val requests: MutableList<Request> = ArrayList()
        for (element in elements) {
            val href = element.attr("href")
            val link = response.request().url().resolve(href) ?: continue
            requests.add(Request(link.url().toString()))
        }
        logger.info { "Found ${requests.size} links from ${response.request().url()}" }
        return requests.toTypedArray()
    }
}
