package com.fooock.baldr.spider

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 */
class SpiderTest {
    private val fakeSpider = FakeSpider()

    @Test
    fun testSpiderName() = assertEquals("fake-spider", fakeSpider.name)

    @Test
    fun testEmptyAllowedDomains() = assertArrayEquals(emptyArray(), fakeSpider.allowedDomains)

    @Test
    fun testEmptyStartUrls() = assertArrayEquals(emptyArray(), fakeSpider.startUrls)
}

class FakeSpider : Spider("fake-spider") {
    override val startUrls: Array<String> = emptyArray()
    override val allowedDomains: Array<String> = emptyArray()
}
