package com.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.sample.R
import com.model.UserPost
import kotlinx.android.synthetic.main.recycle_items.view.*

/**
 * Created by altafshaikh on 09/02/18.
 */
class HomeAdapter(private var dataItemListener: DataItemListener) : RecyclerView.Adapter<HomeAdapter.HomeDataViewHolder>() {

    private var data = emptyList<UserPost>()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeDataViewHolder {
        return HomeDataViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycle_items, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HomeDataViewHolder?, position: Int) {
        holder?.bind(data[position])
        with(holder?.container) {
            this?.setOnClickListener {
                dataItemListener.getItemClickListener(data[position])
            }
        }
    }

    fun setData(data: List<UserPost>) {
        this.data = data
        notifyDataSetChanged()
    }

    class HomeDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userPost: UserPost) {
            with(userPost) {
                itemView.tvTitle.text = title
                itemView.tvDescription.text = body
            }
        }

        val container = itemView.container

    }

    interface DataItemListener {
        fun getItemClickListener(userPost: UserPost)
    }
}