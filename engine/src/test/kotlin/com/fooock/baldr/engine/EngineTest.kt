package com.fooock.baldr.engine

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
        val spider = mock(Spider::class.java)
        engine.spiderService().register(spider)
    }

    @Test
    fun testEmptyPipelineService() {
        val pipeline = mock(Pipeline::class.java)
        engine.pipelineService().register(pipeline)
    }
}
