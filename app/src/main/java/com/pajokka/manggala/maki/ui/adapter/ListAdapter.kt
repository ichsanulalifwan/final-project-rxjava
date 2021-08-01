package com.pajokka.manggala.maki.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.databinding.ItemKknBinding
import com.pajokka.manggala.maki.model.News
import com.pajokka.manggala.maki.ui.detail.DetailActivity
import com.pajokka.manggala.maki.utils.DataMapper

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var listData = ArrayList<News>()

    fun setData(data: ArrayList<News>) {
        this.listData.clear()
        this.listData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapter.ListViewHolder {
        val binding =
            ItemKknBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(private val binding: ItemKknBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            with(binding) {
                tvTitleKkn.text = item.title
                tvDateKkn.text = DataMapper.newsDateFormatter(item.date)

                Glide.with(itemView.context)
                    .load(item.image)
                    .centerCrop()
                    .override(600, 600)
                    .placeholder(R.drawable.image_load)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgItemKkn)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_NEWS, item)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}