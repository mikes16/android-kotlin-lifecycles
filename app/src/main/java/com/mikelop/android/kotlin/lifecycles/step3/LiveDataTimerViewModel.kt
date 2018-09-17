/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikelop.android.kotlin.lifecycles.step3

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
}