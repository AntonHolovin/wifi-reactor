package com.holovin.wifireactor.presentation.screens.wifi.epoxy.models

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.github.anastr.speedviewlib.SpeedView
import com.holovin.wifireactor.R
import com.holovin.wifireactor.domain.wifi.models.SignalLevel

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class WifiSignalItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val speedView: SpeedView

    init {
        inflate(context, R.layout.item_wifi_signal, this)

        speedView = findViewById(R.id.speedview)
        speedView.lowSpeedColor = context.getColor(R.color.red)
        speedView.mediumSpeedColor = context.getColor(R.color.yellow)
        speedView.highSpeedColor = context.getColor(R.color.green)

        speedView.indicatorColor = context.getColor(R.color.colorAccent)
    }

    @JvmOverloads
    @ModelProp
    fun level(level: SignalLevel = SignalLevel.LOW) {
        when (level) {
            SignalLevel.LOW -> speedView.speedTo(16.5f, 1000)
            SignalLevel.MODERATE -> speedView.speedTo(50f, 1000)
            SignalLevel.HIGH -> speedView.speedTo(82.5f, 1000)
        }
    }
}