package com.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.ResultMapper
import com.utils.rx.observe
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by altafshaikh on 01/02/18.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.listOfPosts.observe(this, { result ->
            when (result) {
                is ResultMapper.Success -> {

                }
                is ResultMapper.Failure -> {
                }
            }
        })

    }
}