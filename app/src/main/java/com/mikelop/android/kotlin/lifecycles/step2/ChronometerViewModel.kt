package com.mikelop.android.kotlin.lifecycles.step2

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity

class ChronometerViewModel : ViewModel(){

    var mStartTime:Long? = null

    companion object{
        fun create(activity: AppCompatActivity): ChronometerViewModel =
                ViewModelProviders.of(activity).get(ChronometerViewModel::class.java)
    }
}
