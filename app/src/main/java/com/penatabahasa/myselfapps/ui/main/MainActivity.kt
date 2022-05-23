package com.penatabahasa.myselfapps.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.penatabahasa.myselfapps.R
import com.penatabahasa.myselfapps.databinding.ActivityMainBinding

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        navigationController()
    }

    private fun navigationController() {
        binding?.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            btmNavView.setupWithNavController(navController)
        }
    }
}