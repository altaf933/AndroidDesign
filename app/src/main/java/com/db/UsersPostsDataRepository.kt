package com.db

import com.model.UserPost
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by altafshaikh on 14/02/18.
 */

class UsersPostsDataRepository @Inject constructor(appDatabase: AppDatabase,
                                                   userPostsDao: UserPostsDao) : UsersPostsRepository {
    override fun getPosts(): Flowable<List<UserPost>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun savePosts(userPost: UserPost) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}