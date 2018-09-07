package com.fooock.baldr.example

import com.fooock.baldr.main.Baldr
import com.fooock.baldr.spider.Spider

/**
 * Example entry point
 */
fun main(args: Array<String>) {
    Baldr(spiders = arrayOf(ExampleSpider()))
}

/**
 * Example Spider
 */
class ExampleSpider : Spider("example") {
    override val startUrls: Array<String>
        get() = arrayOf("http://example.com")

}
