package com.holovin.wifireactor.presentation.screens.wifi

import com.airbnb.mvrx.test.MvRxTestRule
import com.airbnb.mvrx.withState
import com.holovin.wifireactor.domain.wifi.WifiReactor
import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import com.holovin.wifireactor.presentation.screens.wifi.SignalState
import com.holovin.wifireactor.presentation.screens.wifi.SignalViewModel
import io.mockk.every
import io.mockk.mockk
import io.reactivex.subjects.PublishSubject
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test

class SignalViewModelShould {
    private val wifiReactor = mockk<WifiReactor>()
    private val wifiSignalSubject = PublishSubject.create<SignalLevel>()

    @Before
    fun setUp() {
        every { wifiReactor.observeWifiSignalLevel() } returns wifiSignalSubject
    }

    @Test
    fun `subscribe to WifiReactor`() {
        // given, when
        val viewModel = SignalViewModel(
            SignalState(),
            wifiReactor
        )

        // then
        @Suppress("UsePropertyAccessSyntax")
        Assertions.assertThat(wifiSignalSubject.hasObservers()).isTrue()
    }

    @Test
    fun `react to data flow form WifiReactor`() {
        // given
        val viewModel = SignalViewModel(
            SignalState(),
            wifiReactor
        )

        // when
        wifiSignalSubject.onNext(SignalLevel.HIGH)

        // then
        withState(viewModel) {
            Assertions.assertThat(it.level).isEqualTo(SignalLevel.HIGH)
        }
    }

    @Test
    fun `emit low signal when created`() {
        // given, when
        val viewModel = SignalViewModel(
            SignalState(),
            wifiReactor
        )

        // then
        withState(viewModel) {
            Assertions.assertThat(it.level).isEqualTo(SignalLevel.LOW)
        }
    }

    companion object {
        @JvmField
        @ClassRule
        val mvrxTestRule = MvRxTestRule()
    }
}