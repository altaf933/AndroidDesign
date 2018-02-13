package com.db;

import com.model.UserPost
import io.reactivex.Flowable

/**
 * Created by altafshaikh on 13/02/18.
 */

interface PostDatabase {

    fun getPosts(): Flowable<List<UserPost>>

    fun savePosts(userPost: UserPost)
}