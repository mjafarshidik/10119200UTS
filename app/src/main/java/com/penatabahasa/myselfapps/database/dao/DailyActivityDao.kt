package com.penatabahasa.myselfapps.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.penatabahasa.myselfapps.database.entities.DailyActivity

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Dao
interface DailyActivityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(dailyActivity: DailyActivity)

    @Query("SELECT * from dailyActivity ORDER BY daId ASC")
    fun getAllDailyActivities(): LiveData<List<DailyActivity>>
}