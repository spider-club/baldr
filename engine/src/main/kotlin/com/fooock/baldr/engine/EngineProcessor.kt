package com.fooock.baldr.engine

import com.fooock.baldr.network.Request

/**
 *
 */
interface EngineProcessor {
    /**
     *
     */
    fun process(request: Request)
}