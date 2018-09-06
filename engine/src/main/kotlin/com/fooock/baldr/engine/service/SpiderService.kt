package com.fooock.baldr.engine.service

import com.fooock.baldr.engine.Service
import com.fooock.baldr.spider.Spider

/**
 *
 */
class SpiderService : Service<Spider> {
    override fun register(service: Spider) {

    }

    override fun unregister(id: String) {

    }

    override fun size(): Int {
        return 0
    }
}
