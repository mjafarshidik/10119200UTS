package com.penatabahasa.myselfapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.penatabahasa.myselfapps.database.dao.DailyActivityDao
import com.penatabahasa.myselfapps.database.dao.FavoriteMusicDao
import com.penatabahasa.myselfapps.database.dao.FriendListDao
import com.penatabahasa.myselfapps.database.dao.GalleryDao
import com.penatabahasa.myselfapps.database.entities.DailyActivity
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic
import com.penatabahasa.myselfapps.database.entities.FriendList
import com.penatabahasa.myselfapps.database.entities.Gallery

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Database(
    entities = [DailyActivity::class, FavoriteMusic::class, FriendList::class, Gallery::class],
    version = 1,
    exportSchema = true
)
abstract class MySelfDatabase : RoomDatabase() {

    abstract fun friendListDao(): FriendListDao
    abstract fun dailyActivityDao(): DailyActivityDao
    abstract fun galleyDao(): GalleryDao
    abstract fun favoriteMusicDao(): FavoriteMusicDao

    companion object {
        @Volatile
        private var INSTANCE: MySelfDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MySelfDatabase {
            if (INSTANCE == null) {
                synchronized(MySelfDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MySelfDatabase::class.java, "my_self"
                    )
                        .createFromAsset("database/my_self.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as MySelfDatabase
        }
    }
}