package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request

/**
 *
 */
interface SchedulerProcessor {
    /**
     *
     */
    fun requestScheduled(request: Request, spiderId: String)
}