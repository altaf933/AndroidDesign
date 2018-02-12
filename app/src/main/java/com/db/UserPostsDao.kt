package com.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.common.ResultMapper
import com.model.UserPost

/**
 * Created by altafshaikh on 12/02/18.
 */

@Dao
interface UserPostsDao {

    @Query("SELECT * FROM posts")
    fun getAllPost(): LiveData<ResultMapper<List<UserPost>>>

    @Insert
    fun insertData(userPost: UserPost)
}