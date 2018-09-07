package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.settings.SettingsManager
import mu.KotlinLogging

/**
 *
 */
class Engine(val settings: SettingsManager) {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Created engine runtime" }
    }
    /**
     *
     */
    fun spiderService(): SpiderService {
        return SpiderService()
    }
}
