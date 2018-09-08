package com.fooock.baldr.engine.service

import com.fooock.baldr.engine.EngineProcessor
import com.fooock.baldr.engine.Service
import com.fooock.baldr.spider.Spider
import mu.KotlinLogging

/**
 *
 */
class SpiderService(private val engineProcessor: EngineProcessor) : Service<Spider> {
    private val logger = KotlinLogging.logger {}

    override fun register(service: Spider) {
        logger.info { "Register new spider '$service'" }
        service.process().forEach { engineProcessor.process(it) }
    }

    override fun unregister(id: String) {

    }

    override fun size(): Int {
        return 0
    }
}
