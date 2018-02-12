package com.db

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.RoomDatabase
import com.model.UserPost

/**
 * Created by altafshaikh on 12/02/18.
 */
@Database(entities = [UserPost::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserPostsDao
}