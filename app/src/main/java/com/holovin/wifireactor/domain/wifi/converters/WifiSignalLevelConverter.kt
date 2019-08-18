package com.holovin.wifireactor.domain.wifi.converters

import com.github.pwittchen.reactivewifi.WifiSignalLevel
import com.holovin.wifireactor.domain.wifi.models.SignalLevel

class WifiSignalLevelConverter {

    fun convert(level: WifiSignalLevel): SignalLevel = when (level) {
        WifiSignalLevel.NO_SIGNAL -> SignalLevel.LOW
        WifiSignalLevel.POOR -> SignalLevel.LOW
        WifiSignalLevel.FAIR -> SignalLevel.MODERATE
        WifiSignalLevel.GOOD -> SignalLevel.HIGH
        WifiSignalLevel.EXCELLENT -> SignalLevel.HIGH
    }

}