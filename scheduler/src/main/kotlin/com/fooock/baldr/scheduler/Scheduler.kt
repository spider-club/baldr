package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.LinkedHashSet

/**
 *
 */
class Scheduler(private val schedulerProcessor: SchedulerProcessor) {
    private val delayedScheduler: ScheduledExecutorService

    val queue = LinkedBlockingQueue<QueueData>()
    val fetchedUrls: MutableSet<Request> = Collections.synchronizedSet(LinkedHashSet())

    val downloadedUrls = AtomicInteger(0)
    val duplicatedUrls = AtomicInteger(0)

    init {
        val threadCount = 3
        delayedScheduler = Executors.newScheduledThreadPool(threadCount)
    }

    /**
     *
     */
    fun add(request: Array<out Request>, spiderId: String) {
        for (r in request) {
            val data = QueueData(r, spiderId)
            if (!fetchedUrls.add(r)) {
                duplicatedUrls.incrementAndGet()
                continue
            }
            queue.put(data)
        }
        for (i in 0..2) delayedScheduler.schedule({ drainQueue() }, 3, TimeUnit.SECONDS)
    }

    private fun drainQueue() {
        val (request, spiderId) = queue.take()
        schedulerProcessor.requestScheduled(request, spiderId)
    }
}
