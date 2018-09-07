package com.fooock.baldr.main

import com.fooock.baldr.engine.Engine
import com.fooock.baldr.settings.SettingsManager
import com.fooock.baldr.spider.Spider

/**
 * Main entry point
 */
class Baldr(settings: SettingsManager = SettingsManager()) {
    private val engine = Engine(settings)

    fun addSpider(spider: Spider) {
        engine.spiderService().register(spider)
    }
}
