package com.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.api.ApiRepository
import com.ui.HomeViewModel
import javax.inject.Inject

/**
 * Created by altafshaikh on 05/02/18.
 */
class ViewModelFactory @Inject constructor(private val apiRepository: ApiRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(apiRepository)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    }
}