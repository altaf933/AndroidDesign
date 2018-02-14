package com.db

import android.arch.lifecycle.LiveData
import com.api.ApiServices
import com.common.ResultMapper
import com.model.UserPost
import com.utils.rx.SchedulerProvider
import com.utils.rx.toLiveData
import com.utils.rx.toResult
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by altafshaikh on 14/02/18.
 */

class UsersPostsDataRepository @Inject constructor(private val api: ApiServices,
                                                   private val appDatabase: AppDatabase,
                                                   private val schedulerProvider: SchedulerProvider,
                                                   private val userPostsDao: UserPostsDao) : UsersPostsRepository {
    override fun remoteData(): LiveData<ResultMapper<List<UserPost>>> {
        return api.getUsersPost().toResult(schedulerProvider)
                .toLiveData()
    }

    override fun getPosts(): Flowable<List<UserPost>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun savePosts(userPost: UserPost) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    val listOfPosts: LiveData<ResultMapper<List<UserPost>>> by lazy {
        api.getUsersPost().toResult(schedulerProvider)
                .toLiveData()
    }
}