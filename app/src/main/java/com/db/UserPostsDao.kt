package com.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.model.UserPost

/**
 * Created by altafshaikh on 12/02/18.
 */

@Dao
abstract class UserPostsDao {

    @Query("SELECT * FROM posts")
    abstract fun getAllPost(): LiveData<List<UserPost>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertData(listUserPost: List<UserPost>)


    @Query("DELETE FROM posts")
    abstract fun deleteAll()

    @Transaction
    open fun clearAndInsert(newSessions: List<UserPost>) {
        deleteAll()
        insertData(newSessions)
    }
}