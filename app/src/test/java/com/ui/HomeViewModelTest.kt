package com.ui

import com.api.ApiRepository
import com.api.ApiServices
import com.model.UserPost
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

/**
 * Created by altafshaikh on 08/02/18.
 */
@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    @Mock
    private val apiServices: ApiServices = mock(ApiServices::class.java)

    @Test
    fun test_empty() {
        apiServices.getUsersPost()
    }
}

interface ApiCallback {
    fun successCallback(listUserPost: List<UserPost>)
    fun errorCallback(thr: Throwable)
}

