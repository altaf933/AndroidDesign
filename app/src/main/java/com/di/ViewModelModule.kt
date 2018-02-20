package com.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.di.annotation.ViewModelKey
import com.factory.ViewModelFactory
import com.ui.home.HomeViewModel
import com.ui.homedetail.HomeDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by altafshaikh on 06/02/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeDetailViewModel::class)
    abstract fun bindHomeDetailViewModel(homeDetailViewModel: HomeDetailViewModel): ViewModel

}