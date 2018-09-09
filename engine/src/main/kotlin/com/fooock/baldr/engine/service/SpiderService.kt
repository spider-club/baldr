package com.fooock.baldr.engine.service

import com.fooock.baldr.engine.EngineProcessor
import com.fooock.baldr.engine.Service
import com.fooock.baldr.network.Request
import com.fooock.baldr.spider.Spider
import com.fooock.baldr.spider.SpiderProcessor
import java.util.concurrent.ConcurrentHashMap

/**
 *
 */
class SpiderService(private val engineProcessor: EngineProcessor) : Service<Spider> {
    private val spiders = ConcurrentHashMap<String, Spider>()

    override fun register(service: Spider) {
        val spiderProcessor = object : SpiderProcessor {
            override fun process(request: Request) = engineProcessor.process(request)
        }
        service.spiderProcessor = spiderProcessor
        service.process()
        spiders["a"] = service
    }

    override fun unregister(id: String) {
        val spider = spiders[id]
        spider?.spiderProcessor = null
    }

    override fun size(): Int {
        return spiders.size
    }
}
