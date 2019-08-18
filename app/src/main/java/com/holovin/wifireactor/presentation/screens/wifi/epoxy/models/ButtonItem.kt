package com.holovin.wifireactor.presentation.screens.wifi.epoxy.models

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.holovin.wifireactor.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ButtonItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.buttonStyle
) : AppCompatButton(context, attrs, defStyleAttr) {

    @ModelProp
    @JvmOverloads
    fun enabled(enabled: Boolean = false) {
        isEnabled = enabled

        text = if (enabled) "Enabled" else "Disabled"
    }

    @CallbackProp
    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
    }
}