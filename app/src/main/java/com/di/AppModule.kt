package com.di

import android.app.Application
import android.content.Context
import com.App
import com.utils.rx.AppSchedulerProvider
import com.utils.rx.ScheduleProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */

@Module(includes = arrayOf(ViewModelModule::class))
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideAppContext(app: Application): Context
}