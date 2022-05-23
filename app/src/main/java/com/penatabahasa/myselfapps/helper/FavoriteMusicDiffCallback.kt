package com.penatabahasa.myselfapps.helper

import androidx.recyclerview.widget.DiffUtil
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteMusicDiffCallback(
    private val mOldFavoriteMusicList: List<FavoriteMusic>,
    private val mNewFavoriteMusicList: List<FavoriteMusic>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldFavoriteMusicList.size
    }

    override fun getNewListSize(): Int {
        return mNewFavoriteMusicList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFavoriteMusicList[oldItemPosition].fmId == mNewFavoriteMusicList[newItemPosition].fmId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldFavoriteMusicList[oldItemPosition]
        val newEmployee = mNewFavoriteMusicList[newItemPosition]
        return oldEmployee.fmId == newEmployee.fmId &&
                oldEmployee.image == newEmployee.image &&
                oldEmployee.title == newEmployee.title &&
                oldEmployee.singer == newEmployee.singer
    }
}