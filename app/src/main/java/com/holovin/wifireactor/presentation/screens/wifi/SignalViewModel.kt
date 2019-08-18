package com.holovin.wifireactor.presentation.screens.wifi

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.holovin.wifireactor.domain.wifi.WifiReactor
import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import org.koin.android.ext.android.inject

class SignalViewModel(
    state: SignalState, private val reactor: WifiReactor
) : BaseMvRxViewModel<SignalState>(state, false) {

    init {
        observeWifiSignalLevel()
    }

    private fun observeWifiSignalLevel() {
        reactor.observeWifiSignalLevel()
            .execute { copy(level = it() ?: SignalLevel.LOW) }
    }

    companion object : MvRxViewModelFactory<SignalViewModel, SignalState> {

        @JvmStatic
        override fun create(viewModelContext: ViewModelContext, state: SignalState): SignalViewModel {
            val reactor: WifiReactor by viewModelContext.activity.inject()

            return SignalViewModel(state, reactor)
        }
    }
}