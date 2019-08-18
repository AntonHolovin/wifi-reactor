package com.holovin.wifireactor.domain.di

import com.holovin.wifireactor.domain.wifi.ReactiveWifiWrapper
import com.holovin.wifireactor.domain.wifi.WifiReactor
import com.holovin.wifireactor.domain.wifi.converters.WifiSignalLevelConverter
import org.koin.dsl.module

val domainModule = module {
    factory { WifiSignalLevelConverter() }

    single<WifiReactor> {
        ReactiveWifiWrapper(get(), get())
    }
}