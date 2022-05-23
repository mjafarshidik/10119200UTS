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
data class FavoriteMusic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fmId")
    var fmId: Int = 0,

    @ColumnInfo(name = "image")
    var image: String? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "singer")
    var singer: String? = null
) : Parcelable
