package com.mikelop.android.kotlin.lifecycles.step3

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.lifecycles.step3.kotlin.LiveDataTimerViewModel
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.chrono_activity_3.*

class ChronoActivity3: AppCompatActivity() {

    lateinit var liveDataTimerViewModel: LiveDataTimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chrono_activity_3)

        liveDataTimerViewModel = LiveDataTimerViewModel().create(this)
        subscribe()
    }

    private fun subscribe() {

        liveDataTimerViewModel.mElapsedTime.observe(this, Observer<Long> {
            timer_textview.text = resources.getString(R.string.seconds, it)
        })

    }

}