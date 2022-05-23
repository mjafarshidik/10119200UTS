package com.penatabahasa.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.penatabahasa.myselfapps.database.entities.FavoriteMusic
import com.penatabahasa.myselfapps.databinding.ItemMusicBinding
import com.penatabahasa.myselfapps.helper.FavoriteMusicDiffCallback

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteMusicAdapter :
    RecyclerView.Adapter<FavoriteMusicAdapter.CardViewViewHolder>() {

    private val listFavMusic = ArrayList<FavoriteMusic>()

    fun setListFavoriteMusic(listFavMusic: List<FavoriteMusic>) {
        val diffCallback = FavoriteMusicDiffCallback(this.listFavMusic, listFavMusic)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listFavMusic.clear()
        this.listFavMusic.addAll(listFavMusic)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listFavMusic[position])
    }

    override fun getItemCount(): Int {
        return listFavMusic.size
    }

    class CardViewViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteMusic: FavoriteMusic) {
            with(binding) {
                tvTitleMusic.text = favoriteMusic.title
                tvDescMusic.text = favoriteMusic.singer

                Glide.with(itemView.context)
                    .load(favoriteMusic.image)
                    .apply(RequestOptions().override(68, 68))
                    .into(ivMusic)
            }
        }
    }
}