package com.penatabahasa.myselfapps.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Dao
interface FavoriteMusicDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteMusic: FavoriteMusic)

    @Query("SELECT * from favoriteMusic ORDER BY fmId ASC")
    fun getAllFavoriteMusics(): LiveData<List<FavoriteMusic>>
}