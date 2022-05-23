package com.penatabahasa.myselfapps.helper

import androidx.recyclerview.widget.DiffUtil
import com.penatabahasa.myselfapps.database.entities.FriendList

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FriendListDiffCallback(
    private val mOldFriendList: List<FriendList>,
    private val mNewFriendList: List<FriendList>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldFriendList.size
    }

    override fun getNewListSize(): Int {
        return mNewFriendList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFriendList[oldItemPosition].flId == mNewFriendList[newItemPosition].flId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldFriendList = mOldFriendList[oldItemPosition]
        val newFriendList = mNewFriendList[newItemPosition]
        return oldFriendList.name == newFriendList.name
                && oldFriendList.picture == newFriendList.picture
    }
}