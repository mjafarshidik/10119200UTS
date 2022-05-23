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
data class Gallery(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gId")
    var gId: Int = 0,

    @ColumnInfo(name = "image")
    var image: String? = null
) : Parcelable
