package com.fooock.baldr.engine

import com.fooock.baldr.network.Request
import com.fooock.baldr.network.Response
import com.fooock.baldr.pipeline.Pipeline
import com.fooock.baldr.settings.SettingsManager
import com.fooock.baldr.spider.Spider
import org.junit.Test
import org.mockito.Mockito.mock

/**
 *
 */
class EngineTest {
    private val engine = Engine(SettingsManager())

    @Test
    fun testEmptySpiderService() {
        val spider = FakeSpider()
        engine.spiderService().register(spider)
    }

    @Test
    fun testEmptyPipelineService() {
        val pipeline = mock(Pipeline::class.java)
        engine.pipelineService().register(pipeline)
    }
}

class FakeSpider : Spider("fake-spider") {
    override val startUrls: Array<String>
        get() = arrayOf("https://example.com")

    override fun parse(response: Response) {
        yield(Request("https://twitter.com"))
    }
}
