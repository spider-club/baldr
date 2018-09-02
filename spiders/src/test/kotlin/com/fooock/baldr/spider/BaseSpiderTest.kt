package com.fooock.baldr.spider

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 */
class BaseSpiderTest {

    @Test
    fun testSpiderName() {
        val fakeSpider = FakeSpider()
        assertEquals("fake-spider", fakeSpider.name)
    }
}

class FakeSpider : BaseSpider("fake-spider")
