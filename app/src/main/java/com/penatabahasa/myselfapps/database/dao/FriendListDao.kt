package com.penatabahasa.myselfapps.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.penatabahasa.myselfapps.database.entities.FriendList

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Dao
interface FriendListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFriendList(friendList: FriendList)

    @Query("SELECT * FROM friendList ORDER BY flId ASC")
    fun getAllFriendList(): LiveData<List<FriendList>>
}