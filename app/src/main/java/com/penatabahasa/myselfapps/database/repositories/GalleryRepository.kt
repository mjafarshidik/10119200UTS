package com.penatabahasa.myselfapps.database.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.penatabahasa.myselfapps.database.MySelfDatabase
import com.penatabahasa.myselfapps.database.dao.GalleryDao
import com.penatabahasa.myselfapps.database.entities.Gallery
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class GalleryRepository(application: Application) {
    private val mGalleryDao: GalleryDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MySelfDatabase.getDatabase(application)
        mGalleryDao = db.galleyDao()
    }

    fun getAllGalleries(): LiveData<List<Gallery>> = mGalleryDao.getAllGalleries()
    fun insert(gallery: Gallery) {
        executorService.execute { mGalleryDao.insert(gallery) }
    }
}