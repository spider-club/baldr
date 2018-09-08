package com.fooock.baldr.network

import mu.KotlinLogging

/**
 *
 */
class Downloader {
    val logger = KotlinLogging.logger { }

    init {
        logger.info { "Downloader initialized" }
    }
}
