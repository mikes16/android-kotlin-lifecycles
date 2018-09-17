package com.mikelop.android.kotlin.lifecycles.step2

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.activity_main.*

class ChronoActivity2:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chronometerViewModel: ChronometerViewModel =
                ChronometerViewModel.create(this)

        val startTime = SystemClock.elapsedRealtime()
        chronometer.base = chronometerViewModel.mStartTime?: run{
            chronometerViewModel.mStartTime = startTime
            startTime
        }
        chronometer.start()
    }

}