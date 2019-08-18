package com.holovin.wifireactor.domain.wifi.converters

import com.github.pwittchen.reactivewifi.WifiSignalLevel
import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import org.assertj.core.api.Assertions
import org.junit.Test

class WifiSignalLevelConverterShould {
    private val converter = WifiSignalLevelConverter()

    @Test
    fun `convert WifiSignalLevel`() {
        // given
        val map = listOf(
            WifiSignalLevel.NO_SIGNAL to SignalLevel.LOW,
            WifiSignalLevel.POOR to SignalLevel.LOW,
            WifiSignalLevel.FAIR to SignalLevel.MODERATE,
            WifiSignalLevel.GOOD to SignalLevel.HIGH,
            WifiSignalLevel.EXCELLENT to SignalLevel.HIGH
        )
            .toMap()

        // when, then
        map.forEach { (input, expected) -> Assertions.assertThat(converter.convert(input)).isEqualTo(expected) }
    }
}