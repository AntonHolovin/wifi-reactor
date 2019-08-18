package com.holovin.wifireactor.presentation.screens.wifi

import com.airbnb.mvrx.MvRxState
import com.holovin.wifireactor.domain.wifi.models.SignalLevel

data class SignalState(val level: SignalLevel = SignalLevel.LOW) : MvRxState