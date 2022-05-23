package com.penatabahasa.myselfapps.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ViewPagerAdapter(private val items: ArrayList<Fragment>, activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}