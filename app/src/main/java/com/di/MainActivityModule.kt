package com.di

import android.support.v7.app.AppCompatActivity
import com.mobiquity.MainActivity
import dagger.Binds
import dagger.Module

/**
 * Created by altafshaikh on 02/02/18.
 */
@Module
interface  MainActivityModule {
    @Binds
    fun provideMainActivity(mainActivity: MainActivity) : AppCompatActivity
}