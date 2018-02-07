package com.api

import com.model.UserPost
import com.ui.ApiCallback
import javax.inject.Inject

/**
 * Created by altafshaikh on 05/02/18.
 */
class ApiRepository @Inject constructor(private val apiServices: ApiServices,
                                        private val apiGateway: ApiGateway) {

    /**
     * This function retrieve the list of user list.
     */
    fun getUserPostList(apiCallback: ApiCallback) {
        apiGateway.subscribeFor(apiServices.getUsersPost(),
                { result: List<UserPost> ->
            apiCallback.successCallback(result)
        }, { error: Throwable ->
            apiCallback.errorCallback(error)
        })
    }

}
