package com.penatabahasa.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.penatabahasa.myselfapps.database.entities.DailyActivity
import com.penatabahasa.myselfapps.databinding.ItemDailyActivityBinding
import com.penatabahasa.myselfapps.helper.DailyActivityDiffCallback

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DailyAdapter :
    RecyclerView.Adapter<DailyAdapter.CardViewViewHolder>() {

    private val listDailyActivity = ArrayList<DailyActivity>()

    fun setListDailyActivity(listDailyActivity: List<DailyActivity>) {
        val diffCallback = DailyActivityDiffCallback(this.listDailyActivity, listDailyActivity)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listDailyActivity.clear()
        this.listDailyActivity.addAll(listDailyActivity)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemDailyActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listDailyActivity[position])
    }

    override fun getItemCount(): Int {
        return listDailyActivity.size
    }

    class CardViewViewHolder(private val binding: ItemDailyActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dailyActivity: DailyActivity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(dailyActivity.image)
                    .apply(RequestOptions().override(68, 68))
                    .into(ivDailyActivity)
                tvTitleDailyActivity.text = dailyActivity.title
                tvDescDailyActivity.text = dailyActivity.description
            }
        }
    }
}