package com.pajokka.manggala.maki.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.databinding.ItemKknBinding
import com.pajokka.manggala.maki.model.Kkn
import com.pajokka.manggala.maki.ui.detail.DetailActivity
import com.pajokka.manggala.maki.utils.DataMapper

class KknAdapter : RecyclerView.Adapter<KknAdapter.FavoriteViewHolder>() {

    private var listData = ArrayList<Kkn>()
    private val dataLimit = 3

    fun setData(favorite: ArrayList<Kkn>) {
        this.listData.clear()
        this.listData.addAll(favorite)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KknAdapter.FavoriteViewHolder {
        val binding =
            ItemKknBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KknAdapter.FavoriteViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = Math.min(listData.size, dataLimit)

    inner class FavoriteViewHolder(private val binding: ItemKknBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Kkn) {
            with(binding) {
                tvTitleKkn.text = item.title
                tvDateKkn.text = DataMapper.kknDateFormatter(item.createdAt)

                Glide.with(itemView.context)
                    .load(item.imageUrl)
                    .centerCrop()
                    .override(600,600)
                    .placeholder(R.drawable.image_load)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgItemKkn)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_KKN, item)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}