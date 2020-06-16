package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank3.*

class BlankFragment3 : Fragment() {
    private lateinit var message: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = this.arguments
        message = bundle?.getString("message").toString()
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        infoMessage.text = message
        btnBack.setOnClickListener {fragmentManager!!.popBackStack()}
    }
}

