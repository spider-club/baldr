package com.fooock.baldr.scheduler

import com.fooock.baldr.network.Request
import com.fooock.baldr.spider.Spider

/**
 *
 */
interface SchedulerProcessor {
    /**
     *
     */
    fun requestScheduled(request: Request, spider: Spider)
}