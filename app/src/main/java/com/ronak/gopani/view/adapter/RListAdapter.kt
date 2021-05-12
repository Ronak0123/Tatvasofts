package com.ronak.gopani.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronak.gopani.view.adapter.viewHolders.RListViewHolder
import com.ronak.gopani.databinding.ViewListItemBinding
import com.ronak.gopani.model.Users
import com.ronak.gopani.view.ui.homeList.RListViewModel

class RListAdapter(private val repoListViewModel: RListViewModel) : RecyclerView.Adapter<RListViewHolder>() {
    var repoList: List<Users> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewListItemBinding.inflate(inflater, parent, false)
        return RListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<Users>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}