package com.penatabahasa.myselfapps.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic
import com.penatabahasa.myselfapps.database.repositories.FavoriteMusicRepository

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteMusicViewModel(application: Application) : ViewModel() {
    private val mFavoriteMusicRepository: FavoriteMusicRepository =
        FavoriteMusicRepository(application)

    fun getAllFavoriteMusics(): LiveData<List<FavoriteMusic>> =
        mFavoriteMusicRepository.getAllFavoriteMusics()

    fun insert(favoriteMusic: FavoriteMusic) {
        mFavoriteMusicRepository.insert(favoriteMusic)
    }
}