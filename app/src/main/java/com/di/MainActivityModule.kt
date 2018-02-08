package com.di

import android.support.v7.app.AppCompatActivity
import com.main.MainActivity
import com.utils.rx.AppSchedulerProvider
import com.utils.rx.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by altafshaikh on 02/02/18.
 */
@Module
interface  MainActivityModule {
    @Binds
    fun provideMainActivity(mainActivity: MainActivity) : AppCompatActivity

}