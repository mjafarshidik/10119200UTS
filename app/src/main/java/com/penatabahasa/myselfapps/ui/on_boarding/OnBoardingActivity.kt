package com.penatabahasa.myselfapps.ui.on_boarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.penatabahasa.myselfapps.adapter.ViewPagerAdapter
import com.penatabahasa.myselfapps.databinding.ActivityOnBoardingBinding
import com.penatabahasa.myselfapps.ui.on_boarding.fragments.OnBoardingOneFragment
import com.penatabahasa.myselfapps.ui.on_boarding.fragments.OnBoardingThreeFragment
import com.penatabahasa.myselfapps.ui.on_boarding.fragments.OnBoardingTwoFragment

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showOnBoarding()
    }

    private fun showOnBoarding() {
        binding.apply {
            val fragmentList: ArrayList<Fragment> = arrayListOf(
                OnBoardingOneFragment(),
                OnBoardingTwoFragment(),
                OnBoardingThreeFragment()
            )

            val adapter = ViewPagerAdapter(fragmentList, this@OnBoardingActivity)
            vpOnBoarding.adapter = adapter
            dotsIndicator.setViewPager2(vpOnBoarding)
        }
    }
}