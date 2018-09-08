package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.PipelineService
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
    private val pipelineService = PipelineService()

    init {
        logger.info { "Created engine runtime" }
    }

    /**
     * Retrieve the spider service of this engine. With this service you can
     * register new [com.fooock.baldr.spider.Spider]s, unregister it given its id
     * and retrieve the number of registered spiders.
     */
    fun spiderService(): SpiderService = spiderService

    /**
     * Retrieve the pipeline service of this engine. With this service you can
     * register new [com.fooock.baldr.pipeline.Pipeline]s, unregister it given its id
     * and retrieve the number of registered pipelines.
     */
    fun pipelineService(): PipelineService = pipelineService
}
