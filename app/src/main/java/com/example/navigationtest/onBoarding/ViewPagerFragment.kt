package com.example.navigationtest.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationtest.R
import com.example.navigationtest.databinding.FragmentViewPagerBinding
import com.example.navigationtest.onBoarding.screens.FirstSScreen
import com.example.navigationtest.onBoarding.screens.SecondScreen
import com.example.navigationtest.onBoarding.screens.ThirdScreen


/**
 * A simple [Fragment] subclass.
 * Use the [ViewPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewPagerFragment : Fragment() {
    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inflate the layout for this fragment

        val fragmentList = arrayListOf<Fragment>(
            FirstSScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val myAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        _binding!!.viewpager.adapter = myAdapter

        return view
    }


}