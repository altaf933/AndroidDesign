package com.repository

import com.api.ApiServices
import com.db.PostDatabase
import com.model.UserPost
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by altafshaikh on 13/02/18.
 */

class PostDataRepository @Inject constructor(api: ApiServices,
                                             postDatabase: PostDatabase) : PostsRepository {

    override fun getUsersPost(): Flowable<List<UserPost>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshPost(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}