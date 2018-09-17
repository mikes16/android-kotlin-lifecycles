package com.mikelop.android.kotlin.lifecycles.step5

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SeekBarViewModel: ViewModel() {
    val seekBarValue = MutableLiveData<Int>()
}