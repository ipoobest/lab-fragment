package com.hoikhong.fragmentlab.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hoikhong.fragmentlab.R

class SecondFragment : Fragment() {

    lateinit var btnBack: Button

    companion object {
        fun newInstance(): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        bindView(rootView)
        return rootView
    }

    private fun bindView(rootView: View?) {
        btnBack = rootView!!.findViewById(R.id.btn_back_stack)
        btnBack.setOnClickListener{
            fragmentManager!!.popBackStack()
        }
    }
}