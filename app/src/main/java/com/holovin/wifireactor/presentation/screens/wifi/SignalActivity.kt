package com.holovin.wifireactor.presentation.screens.wifi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.holovin.wifireactor.R

class SignalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signal)

        initToolbar()
        initFragment()
    }

    private fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
    }

    private fun initFragment() {
        if (supportFragmentManager.findFragmentById(R.id.layout_container) != null) return

        supportFragmentManager.beginTransaction()
            .add(R.id.layout_container, SignalFragment())
            .commitNow()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
