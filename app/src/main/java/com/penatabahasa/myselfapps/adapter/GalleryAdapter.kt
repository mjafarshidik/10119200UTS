package com.penatabahasa.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.penatabahasa.myselfapps.database.entities.Gallery
import com.penatabahasa.myselfapps.databinding.ItemGalleryBinding
import com.penatabahasa.myselfapps.helper.GalleryDiffCallback

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class GalleryAdapter :
    RecyclerView.Adapter<GalleryAdapter.StaggeredGridAdapter>() {

    private var listGallery = ArrayList<Gallery>()

    fun setListGallery(listGallery: List<Gallery>) {
        val diffCallback = GalleryDiffCallback(this.listGallery, listGallery)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listGallery.clear()
        this.listGallery.addAll(listGallery)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredGridAdapter {
        val binding =
            ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StaggeredGridAdapter(binding)
    }

    override fun onBindViewHolder(holder: StaggeredGridAdapter, position: Int) {
        holder.bind(listGallery[position])
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    class StaggeredGridAdapter(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gallery: Gallery) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(gallery.image)
                    .apply(RequestOptions().override(SIZE_ORIGINAL))
                    .into(ivItemGallery)

            }
        }
    }
}