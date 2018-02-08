package com.ui

import com.DummyDataCreator
import com.api.ApiServices
import com.common.ResultMapper
import com.model.UserPost

import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.*

import com.util.TestSchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


/**
 * Created by altafshaikh on 08/02/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel
    @Mock
    private val apiServices: ApiServices = mock()

    @Before
    fun init() {
        whenever(apiServices.refreshPost()).doReturn(Completable.complete())
    }

    @Test
    fun test_empty() {
        whenever(apiServices.getUsersPost()).doReturn(Flowable.empty())
        homeViewModel = HomeViewModel(apiServices, TestSchedulerProvider())
        var result: Observer<ResultMapper<List<UserPost>>> = mock()
        homeViewModel.listOfPosts.observeForever(result)
        verify(apiServices).getUsersPost()
    }

    @Test
    fun postslist_Basic() {
        val listOPost = DummyDataCreator.getPosts();
        whenever(apiServices.getUsersPost()).doReturn(Flowable.just(listOPost))
        homeViewModel = HomeViewModel(apiServices, TestSchedulerProvider())

        var result: Observer<ResultMapper<List<UserPost>>> = mock()
        homeViewModel.listPostMutableLiveData.observeForever(result)
        verifyNoMoreInteractions(result);
        homeViewModel.setLiveData(listOPost)

        verify(apiServices).getUsersPost()
        verify(result).onChanged(ResultMapper.success(listOPost.map { it as UserPost }))
    }

    @Test
    fun postsError() {
//        val error = RuntimeException("test")
        val runtimeException = RuntimeException("test")
        whenever(apiServices.getUsersPost()).doReturn(Flowable.error(runtimeException))
        homeViewModel = HomeViewModel(apiServices, TestSchedulerProvider())

        val result: Observer<ResultMapper<List<UserPost>>> = mock()
        homeViewModel.listPostMutableLiveData.observeForever(result)

//        var item = ResultMapper.error(runtimeException.message,runtimeException)

//        homeViewModel.setLiveData(ResultMapper.error(RuntimeException("Test")))
//        verify(apiServices).getUsersPost()
//        verify(result).onChanged(ResultMapper.error(error))
    }
}


