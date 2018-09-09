package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.PipelineService
import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.network.Downloader
import com.fooock.baldr.network.Request
import com.fooock.baldr.scheduler.Scheduler
import com.fooock.baldr.scheduler.SchedulerProcessor
import com.fooock.baldr.settings.SettingsManager
import com.fooock.baldr.spider.Spider
import com.fooock.baldr.spider.SpiderProcessor
import mu.KotlinLogging

/**
 *
 */
class Engine(val settings: SettingsManager) : SpiderProcessor, SchedulerProcessor {
    private val logger = KotlinLogging.logger {}

    private val downloader = Downloader()
    private val scheduler = Scheduler(this)

    private val spiderService = SpiderService(this)
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

    override fun process(request: Request, spider: Spider) {
        logger.info { "Engine receives $request to schedule from spider '$spider'" }
        scheduler.add(request, spider)
    }

    override fun requestScheduled(request: Request, spider: Spider) {
        logger.info { "Engine receives request ($request) to download" }
        downloader.get(request)
    }
}
