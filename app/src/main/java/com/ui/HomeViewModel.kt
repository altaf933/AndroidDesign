package com.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.api.ApiRepository
import com.common.ResultMapper
import com.model.UserPost
import javax.inject.Inject

/**
 * Created by altafshaikh on 02/02/18.
 */

class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    //    private var listOupdate = MutableLiveData<List<UserPost>>()
    private var listOupdate = MutableLiveData<ResultMapper<List<UserPost>>>()

    fun getUserPosts() {
        apiRepository.getUserPostList(object : ApiCallback {
            override fun successCallback(listUserPost: List<UserPost>) {
                listOupdate.value = ResultMapper.success(listUserPost)
            }

            override fun errorCallback(thr: Throwable) {
                listOupdate.value = ResultMapper.error(thr)
            }
        })
    }
}

interface ApiCallback {
    fun successCallback(listUserPost: List<UserPost>)
    fun errorCallback(thr: Throwable)
}