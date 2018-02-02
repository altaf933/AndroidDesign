package com.api

import com.model.UserPost
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by altafshaikh on 02/02/18.
 */
interface ApiServices {

    @GET("posts")
    fun getUsersPost(): Flowable<List<UserPost>>

    @GET("posts/{id}")
    fun getUserPostDetail(@Path("id") id: Int): Flowable<UserPost>
}