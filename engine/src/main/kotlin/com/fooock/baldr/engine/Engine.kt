package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.network.Downloader
import com.fooock.baldr.scheduler.Scheduler
import com.fooock.baldr.settings.SettingsManager
import mu.KotlinLogging

/**
 *
 */
class Engine(val settings: SettingsManager) {
    private val logger = KotlinLogging.logger {}

    private val downloader = Downloader()
    private val scheduler = Scheduler()
    private val spiderService = SpiderService()

    init {
        logger.info { "Created engine runtime" }
    }

    /**
     *
     */
    fun spiderService(): SpiderService {
        return spiderService
    }
}
