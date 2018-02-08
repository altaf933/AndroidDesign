package com.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.api.ApiServices
import com.common.ResultMapper
import com.model.UserPost
import com.utils.rx.SchedulerProvider
import com.utils.rx.toLiveData
import com.utils.rx.toResult
import javax.inject.Inject

/**
 * Created by altafshaikh on 02/02/18.
 */

class HomeViewModel @Inject constructor(private val apiServices: ApiServices,
                                        private val schedulerProvider: SchedulerProvider) : ViewModel() {

    fun getUserPosts() {
        val listOfUpdatedData: LiveData<ResultMapper<List<UserPost>>> by lazy {
            apiServices.getUsersPost().toResult(schedulerProvider)
                    .toLiveData()
        }
    }
}

interface ApiCallback {
    fun successCallback(listUserPost: List<UserPost>)
    fun errorCallback(thr: Throwable)
}