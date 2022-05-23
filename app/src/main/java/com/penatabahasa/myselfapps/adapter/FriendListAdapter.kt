package com.penatabahasa.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.penatabahasa.myselfapps.database.entities.FriendList
import com.penatabahasa.myselfapps.databinding.ItemFriendListBinding
import com.penatabahasa.myselfapps.helper.FriendListDiffCallback

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FriendListAdapter :
    RecyclerView.Adapter<FriendListAdapter.CardViewViewHolder>() {

    private var listFriends = ArrayList<FriendList>()

    fun setListFriend(listFriends: List<FriendList>) {
        val diffCallback = FriendListDiffCallback(this.listFriends, listFriends)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listFriends.clear()
        this.listFriends.addAll(listFriends)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemFriendListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listFriends[position])
    }

    override fun getItemCount(): Int {
        return listFriends.size
    }

    inner class CardViewViewHolder(private val binding: ItemFriendListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(friendList: FriendList) {
            with(binding) {
                tvFriendNames.text = friendList.name
                Glide.with(itemView.context)
                    .load(friendList.picture)
                    .apply(RequestOptions().override(54, 54))
                    .into(ivFriendPictures)
            }
        }
    }
}