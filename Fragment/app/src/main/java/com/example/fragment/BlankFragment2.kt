package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank2.*

class BlankFragment2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.btnMessage.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("message", edtMessage.text.toString())
            val thirdFragment = BlankFragment3()
            thirdFragment.arguments = bundle
            fragmentManager!!.beginTransaction().replace(
            R.id.frame,thirdFragment).addToBackStack(null).commit()
        }
    }
}

