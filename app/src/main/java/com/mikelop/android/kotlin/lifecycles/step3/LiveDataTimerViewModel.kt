package com.example.android.lifecycles.step3.kotlin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timerTask

class LiveDataTimerViewModel : ViewModel() {

    val ONE_SECOND: Long = 1000
    val mElapsedTime = MutableLiveData<Long>()

    init {
        val mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.scheduleAtFixedRate(timerTask {
            mElapsedTime.postValue((SystemClock.elapsedRealtime() - mInitialTime)/1000)
        }, ONE_SECOND, ONE_SECOND)
    }

    fun create(activity: AppCompatActivity): LiveDataTimerViewModel =
            ViewModelProviders.of(activity).get(LiveDataTimerViewModel::class.java)
}