package com.example.navigationtest.onBoarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationtest.R


/**
 * A simple [Fragment] subclass.
 * Use the [FirstSScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstSScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_s_screen, container, false)
        
        return view
    }


}