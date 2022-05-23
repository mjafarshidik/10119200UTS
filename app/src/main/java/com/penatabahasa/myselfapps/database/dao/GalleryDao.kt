package com.penatabahasa.myselfapps.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.penatabahasa.myselfapps.database.entities.Gallery

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Dao
interface GalleryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(gallery: Gallery)

    @Query("SELECT * from gallery ORDER BY gId ASC")
    fun getAllGalleries(): LiveData<List<Gallery>>
}