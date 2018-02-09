package com.di

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

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}