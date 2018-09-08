package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request
import mu.KotlinLogging

/**
 *
 */
class Scheduler {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Scheduler created" }
    }

    fun add(request: Request) {
        logger.info { "Scheduler prepared to schedule $request" }
    }
}
