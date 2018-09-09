package com.fooock.baldr.engine.service

import com.fooock.baldr.engine.EngineProcessor
import com.fooock.baldr.engine.Service
import com.fooock.baldr.network.Request
import com.fooock.baldr.spider.Spider
import com.fooock.baldr.spider.SpiderProcessor
import mu.KotlinLogging
import java.util.concurrent.ConcurrentHashMap

/**
 *
 */
class SpiderService(private val engineProcessor: EngineProcessor) : Service<Spider> {
    private val logger = KotlinLogging.logger {}
    private val spiders = ConcurrentHashMap<String, Spider>()

    override fun register(service: Spider) {
        spiders[service.id] = service
        logger.info { "Added spider '$service' with id ${service.id}" }

        val spiderProcessor = object : SpiderProcessor {
            override fun process(request: Request) = engineProcessor.process(request)
        }
        service.spiderProcessor = spiderProcessor
        service.process()
    }

    override fun unregister(id: String) {
        val spider = spiders[id]
        spider?.spiderProcessor = null
    }

    override fun size(): Int {
        return spiders.size
    }
}
