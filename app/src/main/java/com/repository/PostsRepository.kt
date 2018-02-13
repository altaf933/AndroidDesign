package com.repository

import android.support.annotation.CheckResult
import com.model.UserPost
import io.reactivex.Completable
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by altafshaikh on 12/02/18.
 */

interface PostsRepository {

    fun getUsersPost(): Flowable<List<UserPost>>

    @CheckResult
    fun refreshPost(): Completable
}