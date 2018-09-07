package com.fooock.baldr.main

import com.fooock.baldr.engine.Engine
import com.fooock.baldr.settings.SettingsManager
import com.fooock.baldr.spider.Spider

/**
 * Main entry point
 */
class Baldr(settings: SettingsManager = SettingsManager(), spiders: Array<Spider>) {
    private val engine = Engine(settings)

    init {
        spiders.forEach { engine.spiderService().register(it) }
    }
}
