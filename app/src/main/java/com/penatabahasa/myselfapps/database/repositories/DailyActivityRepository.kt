package com.penatabahasa.myselfapps.database.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.penatabahasa.myselfapps.database.MySelfDatabase
import com.penatabahasa.myselfapps.database.dao.DailyActivityDao
import com.penatabahasa.myselfapps.database.entities.DailyActivity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DailyActivityRepository(application: Application) {
    private val mDailyActivityDao: DailyActivityDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MySelfDatabase.getDatabase(application)
        mDailyActivityDao = db.dailyActivityDao()
    }

    fun getAllDailyActivities(): LiveData<List<DailyActivity>> =
        mDailyActivityDao.getAllDailyActivities()

    fun insert(dailyActivity: DailyActivity) {
        executorService.execute { mDailyActivityDao.insert(dailyActivity) }
    }
}