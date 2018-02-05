package com.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.api.ApiRepository
import com.model.UserPost
import javax.inject.Inject

/**
 * Created by altafshaikh on 02/02/18.
 */

class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    private var listOupdate = MutableLiveData<List<UserPost>>()
    fun getUserPosts() {
        apiRepository.getUserPostList(object : ApiCallback {
            override fun successCallback(listUserPost: List<UserPost>) {
                listOupdate.value = listUserPost
            }
            override fun errorCallback(thr: Throwable) {
            }
        })
    }
}

interface ApiCallback {
    fun successCallback(listUserPost: List<UserPost>)
    fun errorCallback(thr: Throwable)
}