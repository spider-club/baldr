package com.fooock.baldr.scheduler

import mu.KotlinLogging

/**
 *
 */
class Scheduler {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Scheduler created" }
    }
}
