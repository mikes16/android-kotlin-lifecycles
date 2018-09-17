package com.mikelop.android.kotlin.lifecycles.step5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mikelop.android.kotlin.lifecycles.R

class ActivityStep5:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step5)
    }
}