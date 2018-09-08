package com.fooock.baldr.engine.service

import com.fooock.baldr.engine.Service
import com.fooock.baldr.pipeline.Pipeline
import mu.KotlinLogging

/**
 *
 */
class PipelineService : Service<Pipeline> {
    private val logger = KotlinLogging.logger {}

    override fun register(service: Pipeline) {
        logger.info { "Register new pipeline '$service'" }
    }

    override fun unregister(id: String) {

    }

    override fun size(): Int {
        return 0
    }
}
