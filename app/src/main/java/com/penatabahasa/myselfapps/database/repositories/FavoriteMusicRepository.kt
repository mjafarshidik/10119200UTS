package com.penatabahasa.myselfapps.database.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.penatabahasa.myselfapps.database.MySelfDatabase
import com.penatabahasa.myselfapps.database.dao.FavoriteMusicDao
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteMusicRepository(application: Application) {
    private val mFavoriteMusicDao: FavoriteMusicDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MySelfDatabase.getDatabase(application)
        mFavoriteMusicDao = db.favoriteMusicDao()
    }

    fun getAllFavoriteMusics(): LiveData<List<FavoriteMusic>> =
        mFavoriteMusicDao.getAllFavoriteMusics()

    fun insert(favoriteMusic: FavoriteMusic) {
        executorService.execute { mFavoriteMusicDao.insert(favoriteMusic) }
    }
}