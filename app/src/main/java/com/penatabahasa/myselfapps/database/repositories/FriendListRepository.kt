package com.penatabahasa.myselfapps.database.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.penatabahasa.myselfapps.database.entities.FriendList
import com.penatabahasa.myselfapps.database.MySelfDatabase
import com.penatabahasa.myselfapps.database.dao.FriendListDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FriendListRepository(application: Application) {
    private val mFriendListDao: FriendListDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MySelfDatabase.getDatabase(application)
        mFriendListDao = db.friendListDao()
    }

    fun getAllFriendList(): LiveData<List<FriendList>> = mFriendListDao.getAllFriendList()
    fun insert(friendList: FriendList) {
        executorService.execute { mFriendListDao.insertFriendList(friendList) }
    }
}