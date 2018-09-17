package com.mikelop.android.kotlin.lifecycles.step5

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.fragment_step5.view.*

class FragmentStep5: Fragment(){
    private val mSeekBarViewModel: SeekBarViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_step5, container, false)

        // TODO: get ViewModel
        subscribeSeekBar(root.seekBar)

        return root
    }

    private fun subscribeSeekBar(seekBar: SeekBar) {

        // Update the ViewModel when the SeekBar is changed.
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO: Set the ViewModel's value when the change comes from the user.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // TODO: Update the SeekBar when the ViewModel is changed.
        // mSeekBarViewModel.seekbarValue.observe(...
    }
}