package com.holovin.wifireactor.presentation.screens.wifi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.holovin.wifireactor.R
import com.holovin.wifireactor.domain.wifi.models.SignalLevel
import com.holovin.wifireactor.presentation.screens.wifi.epoxy.models.buttonItem
import com.holovin.wifireactor.presentation.screens.wifi.epoxy.models.loremIpsumItem
import com.holovin.wifireactor.presentation.screens.wifi.epoxy.models.wifiSignalItem

class SignalFragment : BaseMvRxFragment() {
    private val viewModel: SignalViewModel by fragmentViewModel()

    private lateinit var recyclerView: EpoxyRecyclerView;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_signal, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setItemSpacingRes(R.dimen.margin_normal)
    }

    override fun invalidate() {
        withState(viewModel) { state ->

            // EpoxyController analogue
            recyclerView.withModels {
                wifiSignalItem {
                    id("WifiSignalItem")
                    level(state.level)
                }

                if (state.level == SignalLevel.MODERATE) {
                    loremIpsumItem {
                        id("loremIpsumItem")
                    }
                }

                buttonItem {
                    id("buttonItem")
                    enabled(state.level != SignalLevel.LOW)

                    onClickListener { _ -> showButtonClicked() }
                }
            }
        }
    }

    private fun showButtonClicked() {
        Toast.makeText(this@SignalFragment.requireContext(), "Button has been clicked", Toast.LENGTH_SHORT)
            .show()
    }
}