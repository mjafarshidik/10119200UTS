package com.penatabahasa.myselfapps.ui.on_boarding.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.penatabahasa.myselfapps.databinding.FragmentOnBoardingThreeBinding
import com.penatabahasa.myselfapps.ui.main.MainActivity

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class OnBoardingThreeFragment : Fragment() {
    private var _binding: FragmentOnBoardingThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intentToMainActivity()
    }

    private fun intentToMainActivity() {
        binding.apply {
            btnNext.setOnClickListener {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}