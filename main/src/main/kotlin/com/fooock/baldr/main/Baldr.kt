package com.fooock.baldr.main

import com.fooock.baldr.settings.SettingsManager

/**
 * Main entry point
 */
class Baldr(settings: SettingsManager = SettingsManager()) {
    init {
        println(settings)
    }
}
