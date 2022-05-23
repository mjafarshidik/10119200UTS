package com.penatabahasa.myselfapps.ui.on_boarding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.penatabahasa.myselfapps.databinding.FragmentOnBoardingTwoBinding

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class OnBoardingTwoFragment : Fragment() {
    private var _binding: FragmentOnBoardingTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}