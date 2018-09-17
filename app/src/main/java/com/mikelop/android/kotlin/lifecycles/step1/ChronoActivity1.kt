package com.mikelop.android.kotlin.lifecycles.step1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.activity_main.*

class ChronoActivity1:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer.start()
    }
}