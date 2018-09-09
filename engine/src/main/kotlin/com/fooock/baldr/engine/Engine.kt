package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.PipelineService
import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.network.Downloader
import com.fooock.baldr.network.DownloaderProcessor
import com.fooock.baldr.network.Request
import com.fooock.baldr.network.Response
import com.fooock.baldr.scheduler.Scheduler
import com.fooock.baldr.scheduler.SchedulerProcessor
import com.fooock.baldr.settings.SettingsManager
import com.fooock.baldr.spider.Spider
import com.fooock.baldr.spider.SpiderProcessor
import mu.KotlinLogging

/**
 *
 */
class Engine(val settings: SettingsManager) : SpiderProcessor, SchedulerProcessor, DownloaderProcessor {
    private val logger = KotlinLogging.logger {}

    private val downloader = Downloader(this)
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

    override fun process(request: Array<out Request>, spider: Spider) {
        logger.info { "Process ${request.size} request for $spider" }
        scheduler.add(request, spider.id)
    }

    override fun requestScheduled(request: Request, spiderId: String) {
        downloader.get(request, spiderId)
    }

    override fun onInvalidResponse(request: Request, spiderId: String) {
        logger.warn { "Invalid response for $request (spider=$spiderId)" }
    }

    override fun onUrlNotFound(request: Request, spiderId: String) {
        logger.warn { "Url $request not found (spider=$spiderId)" }
    }

    override fun onServerError(request: Request, spiderId: String) {
        logger.warn { "Server error for request $request (spider=$spiderId)" }
    }

    override fun onSuccessResponse(request: Request, response: Response, spiderId: String) {
        scheduler.downloadedUrls.incrementAndGet()
        spiderService.get(spiderId)?.parse(response)

        logger.info {
            "Queue(${scheduler.queue.size}) / " +
                    "Unique(${scheduler.fetchedUrls.size}) / " +
                    "Downloaded(${scheduler.downloadedUrls.get()}) / " +
                    "Duplicated(${scheduler.duplicatedUrls.get()})"
        }
    }
}
