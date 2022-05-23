package com.penatabahasa.myselfapps.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Entity
@Parcelize
data class FriendList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "flId")
    var flId: Int = 0,

    @ColumnInfo(name = "picture")
    var picture: String? = null,

    @ColumnInfo(name = "name")
    var name: String? = null
) : Parcelable