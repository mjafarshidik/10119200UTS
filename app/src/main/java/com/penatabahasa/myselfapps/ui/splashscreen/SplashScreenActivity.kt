package com.penatabahasa.myselfapps.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.penatabahasa.myselfapps.databinding.ActivitySplashScreenBinding
import com.penatabahasa.myselfapps.ui.on_boarding.OnBoardingActivity
import kotlinx.coroutines.*

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private var binding: ActivitySplashScreenBinding? = null
    private var time = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        withCoroutine(time)
    }

    private fun withCoroutine(time: Long) {
        val mScope = CoroutineScope(Dispatchers.IO)
        mScope.launch {
            delay(time)
            withContext(Dispatchers.Main) {
                launchPostSplashActivity()
                mScope.cancel(null)
            }
        }
    }

    private fun launchPostSplashActivity() {
        val intent = Intent(this, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}