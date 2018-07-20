package com.hoikhong.fragmentlab.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hoikhong.fragmentlab.R

class MainFragment : Fragment() {

    var someVar: Int = 0
    lateinit var tvMainFragment: TextView

    companion object {
        fun newInstance(someVar: Int): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putInt("somevar", someVar)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        someVar = arguments!!.getInt("somevar")
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        bindView(rootView)
        return rootView
    }

    private fun bindView(rootView: View?) {
        tvMainFragment = rootView!!.findViewById(R.id.tv_fragment_main)

    }

    //set value from activity
    fun setHelloText(text: String) {
        tvMainFragment.text = text
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            //Restore state here
        }
    }
}