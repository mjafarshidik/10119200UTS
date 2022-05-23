package com.penatabahasa.myselfapps.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.penatabahasa.myselfapps.database.entities.FriendList
import com.penatabahasa.myselfapps.database.repositories.FriendListRepository

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FriendListViewModel(application: Application) : ViewModel() {
    private val mFriendListRepository: FriendListRepository = FriendListRepository(application)

    fun getAllFriendLists(): LiveData<List<FriendList>> = mFriendListRepository.getAllFriendList()

    fun insert(friendList: FriendList) {
        mFriendListRepository.insert(friendList)
    }
}