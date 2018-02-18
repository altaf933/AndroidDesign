package com.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import com.api.ApiServices
import com.common.ResultMapper
import com.db.UsersPostsRepository
import com.model.UserPost
import com.utils.rx.SchedulerProvider
import com.utils.rx.toLiveData
import com.utils.rx.toResult
import javax.inject.Inject

/**
 * Created by altafshaikh on 02/02/18.
 */

class HomeViewModel @Inject constructor(private val repository: UsersPostsRepository) : ViewModel() {
    @VisibleForTesting
    var listPostMutableLiveData = MutableLiveData<ResultMapper<List<UserPost>>>()

    @VisibleForTesting
    fun setLiveData(listOPost: LiveData<ResultMapper<List<UserPost>>>) {
        listPostMutableLiveData.value = listOPost.value
    }

    val listOfPosts: LiveData<ResultMapper<List<UserPost>>> by lazy {
        repository.remoteData()
    }
}
