package com.fooock.baldr.spider

import com.fooock.baldr.network.Request

/**
 *
 */
interface SpiderProcessor {
    fun process(request: Request)
}