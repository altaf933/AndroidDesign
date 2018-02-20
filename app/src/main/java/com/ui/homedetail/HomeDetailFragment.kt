package com.ui.homedetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.ResultMapper
import com.main.sample.R
import com.utils.rx.observe
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.posts_details.*
import javax.inject.Inject

/**
 * Created by altafshaikh on 20/02/18.
 */

class HomeDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var id: Int? = 0

    companion object {
        private const val KEY_POST_ID = "id"
        fun newInstance(id: Int): Fragment {
            val bundle = Bundle()
            with(bundle) {
                putInt(KEY_POST_ID, id)
            }
            val fragment = HomeDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val homeDetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeDetailViewModel::class.java)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(arguments) {
            id = arguments?.getInt(KEY_POST_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.posts_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // homeDetailViewModel.getPostsDetail(id ?: 0)

        homeDetailViewModel.getPostsDetail(id?:0).observe(this, { result ->
            when (result) {
                is ResultMapper.Success -> {
                    tvDetailTitle.text = result.data.title
                    tvDetailDescription.text = result.data.body
                }
                is ResultMapper.Failure -> {

                }
            }
        })
    }
}