package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request
import com.fooock.baldr.spider.Spider
import mu.KotlinLogging
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 *
 */
class Scheduler(private val schedulerProcessor: SchedulerProcessor) {
    private val logger = KotlinLogging.logger {}
    private val delayedScheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(3)

    /**
     *
     */
    fun add(request: Request, spider: Spider) {
        logger.info { "Scheduler prepared to schedule $request for spider $spider" }
        delayedScheduler.schedule({
            schedulerProcessor.requestScheduled(request, spider)
        }, 5, TimeUnit.SECONDS)
    }
}
