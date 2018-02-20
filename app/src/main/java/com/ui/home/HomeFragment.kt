package com.ui.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.ResultMapper
import com.main.FragmentReplaceListener
import com.main.sample.R
import com.model.UserPost
import com.ui.homedetail.HomeDetailFragment

import com.utils.rx.observe
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.recycle_views.*
import javax.inject.Inject

/**
 * Created by altafshaikh on 01/02/18.
 */
class HomeFragment : Fragment(), HomeAdapter.DataItemListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var homeAdapter: HomeAdapter? = null

    private var fragmentChangeListener: FragmentReplaceListener? = null

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        // Is the interface implemented ?
        if(context !is FragmentReplaceListener)
            throw ClassCastException(context.toString() + "must implement OnImageClickListener")
        else
            fragmentChangeListener = context

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycle_views, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        viewModel.listOfPosts.observe(this, { result ->
            when (result) {
                is ResultMapper.Success -> {
                    homeAdapter?.setData(result.data)
                }
                is ResultMapper.Failure -> {
                }
            }
        })
    }

    private fun setupRecycleView() {
        homeAdapter = HomeAdapter(this)
        rvPosts.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = homeAdapter
        }
    }

    override fun getItemClickListener(userPost: UserPost) {
        var fragment = HomeDetailFragment.newInstance(userPost.id ?: 0)
        fragmentChangeListener?.onFragmentChange(fragment)
    }
}