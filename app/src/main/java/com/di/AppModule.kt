package com.di

import android.app.Application
import android.content.Context
import com.utils.rx.SchedulerProvider
import dagger.Binds
import dagger.Module
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