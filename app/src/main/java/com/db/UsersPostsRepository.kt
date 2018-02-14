package com.db;

import android.arch.lifecycle.LiveData
import com.common.ResultMapper
import com.model.UserPost
import io.reactivex.Flowable

/**
 * Created by altafshaikh on 13/02/18.
 */

interface UsersPostsRepository {

    fun getPosts(): Flowable<List<UserPost>>

    fun savePosts(userPost: UserPost)

    fun remoteData(): LiveData<ResultMapper<List<UserPost>>>
}