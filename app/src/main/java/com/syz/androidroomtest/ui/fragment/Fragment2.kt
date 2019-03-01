package com.syz.androidroomtest.ui.fragment

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProviders
import com.syz.androidroomtest.vm.ShareViewModel
import kotlinx.android.synthetic.main.fragment_fragment1.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Fragment1.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Fragment2 : Fragment() {

    private var model:ShareViewModel?=null
    private var i=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.syz.androidroomtest.R.layout.fragment_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            model = ViewModelProviders.of(it).get(ShareViewModel::class.java)
        }
        fragText.text = "${this::class.java.name}:click send msg"
        fragText.setOnClickListener {
            model?.items?.value = ClipData.Item("num:${i++}")
        }

    }



}
