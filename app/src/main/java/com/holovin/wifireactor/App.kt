package com.holovin.wifireactor

import android.app.Application
import com.holovin.wifireactor.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        iniTimber()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)

            modules(domainModule)
        }
    }

    private fun iniTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}