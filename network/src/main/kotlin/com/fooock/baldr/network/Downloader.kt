package com.fooock.baldr.network

import mu.KotlinLogging

/**
 *
 */
class Downloader {
    private val logger = KotlinLogging.logger { }

    /**
     *
     */
    fun get(request: Request) {
        logger.info { "Downloading $request" }
    }
}
