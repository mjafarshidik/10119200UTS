package com.penatabahasa.myselfapps.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.penatabahasa.myselfapps.database.entities.DailyActivity
import com.penatabahasa.myselfapps.database.repositories.DailyActivityRepository

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DailyActivityViewModel(application: Application) : ViewModel() {
    private val mDailyActivityRepository: DailyActivityRepository =
        DailyActivityRepository(application)

    fun getAllDailyActivities(): LiveData<List<DailyActivity>> =
        mDailyActivityRepository.getAllDailyActivities()

    fun insert(dailyActivity: DailyActivity) {
        mDailyActivityRepository.insert(dailyActivity)
    }
}