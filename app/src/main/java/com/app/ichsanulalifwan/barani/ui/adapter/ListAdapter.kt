package com.app.ichsanulalifwan.barani.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.ichsanulalifwan.barani.R
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.utils.Utils
import com.app.ichsanulalifwan.barani.databinding.ItemKknBinding
import com.app.ichsanulalifwan.barani.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

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
                tvDateKkn.text = Utils.newsDateFormatter(item.date)

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