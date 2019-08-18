package com.holovin.wifireactor.domain.wifi

import android.content.Context
import com.github.pwittchen.reactivewifi.ReactiveWifi
import com.holovin.wifireactor.domain.wifi.converters.WifiSignalLevelConverter
import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ReactiveWifiWrapper(
    private val context: Context, private val converter: WifiSignalLevelConverter
) : WifiReactor {

    override fun observeWifiSignalLevel(): Observable<SignalLevel> {
        return ReactiveWifi.observeWifiSignalLevel(context)
            .map { converter.convert(it) }
            .subscribeOn(Schedulers.io())
    }
}