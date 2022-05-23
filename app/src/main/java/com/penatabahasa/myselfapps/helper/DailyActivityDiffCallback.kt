package com.penatabahasa.myselfapps.helper

import androidx.recyclerview.widget.DiffUtil
import com.penatabahasa.myselfapps.database.entities.DailyActivity

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DailyActivityDiffCallback(
    private val mOldDailyActivityList: List<DailyActivity>,
    private val mNewDailyActivityList: List<DailyActivity>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldDailyActivityList.size
    }

    override fun getNewListSize(): Int {
        return mNewDailyActivityList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldDailyActivityList[oldItemPosition].daId == mNewDailyActivityList[newItemPosition].daId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldDailyActivityList[oldItemPosition]
        val newEmployee = mNewDailyActivityList[newItemPosition]
        return oldEmployee.daId == newEmployee.daId && oldEmployee.image == newEmployee.image && oldEmployee.title == newEmployee.title && oldEmployee.description == newEmployee.description
    }
}