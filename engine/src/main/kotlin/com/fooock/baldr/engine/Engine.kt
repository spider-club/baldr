package com.fooock.baldr.engine

import com.fooock.baldr.engine.service.SpiderService
import com.fooock.baldr.settings.SettingsManager

/**
 *
 */
class Engine(val settings: SettingsManager) {
    /**
     *
     */
    fun spiderService(): SpiderService {
        return SpiderService()
    }
}
