package com.holovin.wifireactor.domain.wifi

import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import io.reactivex.Observable

interface WifiReactor {
    fun observeWifiSignalLevel(): Observable<SignalLevel>
}