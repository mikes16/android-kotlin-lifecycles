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

package com.mikelop.android.kotlin.lifecycles.step2

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.activity_main.*

class ChronoActivity2:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)
        val startTime = SystemClock.elapsedRealtime()

        chronometer.base = chronometerViewModel.mStartTime?: run{
            chronometerViewModel.mStartTime = startTime
            startTime
        }
        chronometer.start()
    }

}