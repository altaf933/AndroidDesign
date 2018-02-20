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

    fun getPostsDetail(id: Int): LiveData<ResultMapper<UserPost>>

    fun savePosts(userPost: ResultMapper<List<UserPost>>)

    fun remoteData(): LiveData<ResultMapper<List<UserPost>>>
}