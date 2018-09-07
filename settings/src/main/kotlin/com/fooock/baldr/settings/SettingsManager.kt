package com.fooock.baldr.settings

import mu.KotlinLogging

/**
 *
 */
class SettingsManager {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Created settings manager" }
    }
}
