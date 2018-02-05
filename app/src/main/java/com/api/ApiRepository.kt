package com.api

import android.util.Log
import com.ui.ApiCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by altafshaikh on 05/02/18.
 */
class ApiRepository(private val apiServices: ApiServices) {

    /**
     * This function retrieve the list of user list.
     *
     */
    fun getUserPostList(apiCallback: ApiCallback) {
        apiServices.getUsersPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("TAG",it.toString())
                    apiCallback.successCallback(it)
                }, {
                    Log.e("TAG",it.message)
                    apiCallback.errorCallback(it)
                })

    }

}
