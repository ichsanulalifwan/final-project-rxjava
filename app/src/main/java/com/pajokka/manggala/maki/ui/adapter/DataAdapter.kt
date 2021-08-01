package com.pajokka.manggala.maki.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.databinding.ItemNewsBinding
import com.pajokka.manggala.maki.model.News
import com.pajokka.manggala.maki.ui.detail.DetailActivity
import com.pajokka.manggala.maki.utils.DataMapper
import kotlin.collections.ArrayList

class DataAdapter : RecyclerView.Adapter<DataAdapter.FavoriteViewHolder>() {

    private var listData = ArrayList<News>()
    private val dataLimit = 5

    fun setData(favorite: ArrayList<News>) {
        this.listData.clear()
        this.listData.addAll(favorite)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAdapter.FavoriteViewHolder {
        val binding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataAdapter.FavoriteViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = Math.min(listData.size, dataLimit)

    inner class FavoriteViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            with(binding) {
                tvTitleNews.text = item.title
                tvDateNews.text = DataMapper.newsDateFormatter(item.date)

                Glide.with(itemView.context)
                    .load(item.image)
                    .centerCrop()
                    .placeholder(R.drawable.image_load)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgItemNews)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_NEWS, item)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}