package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.spider.Spider
import org.junit.Test
import org.mockito.Mockito.mock

/**
 *
 */
class EngineTest {
    private val engine = FakeEngine()

    @Test
    fun testEmptySpiderService() {
        val spider = mock(Spider::class.java)
        engine.spiderService().register(spider)
    }
}

class FakeEngine : Engine {
    override fun spiderService(): SpiderService {
        return SpiderService()
    }
}
