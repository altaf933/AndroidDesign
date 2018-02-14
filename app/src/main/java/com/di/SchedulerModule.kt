package com.di

import com.api.ApiServices
import com.db.UsersPostsRepository
import com.repository.PostDataRepository
import com.utils.rx.AppSchedulerProvider
import com.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by altafshaikh on 08/02/18.
 */

@Module
class SchedulerModule {

    @Provides
    fun providePostsRepository(apiServices: ApiServices, postDatabase: UsersPostsRepository) = PostDataRepository(apiServices, postDatabase)

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}