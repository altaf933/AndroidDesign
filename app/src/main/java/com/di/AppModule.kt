package com.di

import android.app.Application
import android.arch.persistence.room.Room
import com.db.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application) =
            Room.databaseBuilder(app, AppDatabase::class.java, "app-database").build()

    @Provides
    @Singleton
    fun providePostsDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    @Singleton
    fun provideUserPostsDatabase(appDatabase: AppDatabase, userPostsDao: UserPostsDao): UsersPostsRepository =
            UsersPostsDataRepository(appDatabase, userPostsDao)
}