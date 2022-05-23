package com.penatabahasa.myselfapps.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.penatabahasa.myselfapps.database.entities.Gallery
import com.penatabahasa.myselfapps.database.repositories.GalleryRepository

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class GalleryViewModel(application: Application) : ViewModel() {
    private val mGalleryRepository: GalleryRepository = GalleryRepository(application)
    fun getAllGalleries(): LiveData<List<Gallery>> = mGalleryRepository.getAllGalleries()

    fun insert(gallery: Gallery) {
        mGalleryRepository.insert(gallery)
    }
}