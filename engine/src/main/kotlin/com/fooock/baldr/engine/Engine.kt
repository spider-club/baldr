package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.SpiderService

/**
 *
 */
interface Engine {
    /**
     *
     */
    fun spiderService(): SpiderService
}
