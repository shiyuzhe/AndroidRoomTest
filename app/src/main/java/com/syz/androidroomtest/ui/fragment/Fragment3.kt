package com.syz.androidroomtest.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProviders
import com.syz.androidroomtest.vm.ShareViewModel
import kotlinx.android.synthetic.main.fragment_fragment1.*



class Fragment3 : Fragment() {

    private var model:ShareViewModel?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.syz.androidroomtest.R.layout.fragment_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            model = ViewModelProviders.of(it).get(ShareViewModel::class.java)
        }
        fragText.text = "${this::class.java.name}:record data change"
        model?.items?.observeForever {
            fragText.text = it.text
        }


    }



}
