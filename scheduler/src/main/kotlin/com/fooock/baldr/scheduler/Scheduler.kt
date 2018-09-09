package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request
import mu.KotlinLogging
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 *
 */
class Scheduler(private val processor: SchedulerProcessor) {
    private val logger = KotlinLogging.logger {}
    private val delayedScheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(3)

    fun add(request: Request) {
        logger.info { "Scheduler prepared to schedule $request" }
        delayedScheduler.schedule({ processor.requestScheduled(request) }, 5, TimeUnit.SECONDS)
    }
}
