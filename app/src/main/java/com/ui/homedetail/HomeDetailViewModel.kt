package com.ui.homedetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.common.ResultMapper
import com.db.UsersPostsRepository
import com.model.UserPost
import javax.inject.Inject

/**
 * Created by altafshaikh on 20/02/18.
 */

class HomeDetailViewModel @Inject constructor(private var repository: UsersPostsRepository) : ViewModel() {

    fun getPostsDetail(id: Int): LiveData<ResultMapper<UserPost>> {
        return repository.getPostsDetail(id)
    }

}