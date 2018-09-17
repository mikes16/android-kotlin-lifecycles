package com.mikelop.android.kotlin.lifecycles.step5_solution

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.mikelop.android.kotlin.lifecycles.R
import com.mikelop.android.kotlin.lifecycles.step5.SeekBarViewModel
import kotlinx.android.synthetic.main.fragment_step5.view.*

class FragmentStep5: Fragment(){
    lateinit var mSeekBarViewModel: SeekBarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_step5, container, false)

        mSeekBarViewModel = ViewModelProviders.of(activity!!).get(SeekBarViewModel::class.java)
        subscribeSeekBar(root.seekBar)

        return root
    }

    private fun subscribeSeekBar(seekBar: SeekBar) {

        // Update the ViewModel when the SeekBar is changed.
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekBarViewModel.seekBarValue.postValue(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

         mSeekBarViewModel.seekBarValue.observe(activity!!, Observer<Int> {
             seekBar.progress = it!!
         })
    }
}