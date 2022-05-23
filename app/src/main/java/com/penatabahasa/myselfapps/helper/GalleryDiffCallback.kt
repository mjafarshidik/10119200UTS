package com.penatabahasa.myselfapps.helper

import androidx.recyclerview.widget.DiffUtil
import com.penatabahasa.myselfapps.database.entities.Gallery

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class GalleryDiffCallback(
    private val mOldGalleryList: List<Gallery>,
    private val mNewGalleryList: List<Gallery>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldGalleryList.size
    }

    override fun getNewListSize(): Int {
        return mNewGalleryList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldGalleryList[oldItemPosition].gId == mNewGalleryList[newItemPosition].gId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldGalleryList[oldItemPosition]
        val newEmployee = mNewGalleryList[newItemPosition]
        return oldEmployee.gId == newEmployee.gId &&
                oldEmployee.image == newEmployee.image
    }
}