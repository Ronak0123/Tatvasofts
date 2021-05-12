package com.ronak.gopani.view.adapter.viewHolders

import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ronak.gopani.BR
import com.ronak.gopani.model.Data
import com.ronak.gopani.model.Users
import com.ronak.gopani.view.ui.homeList.RListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_list_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class RListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val repoListViewModel: RListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    val subavatarImage = itemView.subimages

    fun setup(itemData: Users) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.image).into(avatarImage)

        if (itemData.items.size!=0){
            for (item in itemData.items){
                Picasso.get().load(item).into(subavatarImage)

            }
        }
    }
}