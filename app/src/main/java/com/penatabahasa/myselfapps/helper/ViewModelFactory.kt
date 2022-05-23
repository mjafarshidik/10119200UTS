package com.penatabahasa.myselfapps.helper

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.penatabahasa.myselfapps.viewmodel.DailyActivityViewModel
import com.penatabahasa.myselfapps.viewmodel.FavoriteMusicViewModel
import com.penatabahasa.myselfapps.viewmodel.FriendListViewModel
import com.penatabahasa.myselfapps.viewmodel.GalleryViewModel

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ViewModelFactory private constructor(private val mApplication: Application) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DailyActivityViewModel::class.java) -> {
                DailyActivityViewModel(mApplication) as T
            }
            modelClass.isAssignableFrom(FavoriteMusicViewModel::class.java) -> {
                FavoriteMusicViewModel(mApplication) as T
            }
            modelClass.isAssignableFrom(FriendListViewModel::class.java) -> {
                FriendListViewModel(mApplication) as T
            }
            modelClass.isAssignableFrom(GalleryViewModel::class.java) -> {
                GalleryViewModel(mApplication) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}