package com.app.ichsanulalifwan.barani.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.ichsanulalifwan.barani.R
import com.app.ichsanulalifwan.barani.core.model.Kkn
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.databinding.ActivityDetailBinding
import com.app.ichsanulalifwan.barani.ui.MainActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // prevent dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getDataKKN = intent.getParcelableExtra<Kkn>(EXTRA_KKN)
        val getDataNews = intent.getParcelableExtra<News>(EXTRA_NEWS)

        initListener()

        if (getDataKKN != null) {
            populateKKN(getDataKKN)
        } else if (getDataNews != null) {
            populateNews(getDataNews)
        }
    }

    private fun initListener() {
        binding.ivBack.setOnClickListener {
            startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun populateKKN(dataKkn: Kkn) {
        binding.run {
            tvNameDetail.text = dataKkn.title
            tvAuthor.text = dataKkn.author
            tvDateTimeLoc.text = DataMapper.kknDateFormatter(dataKkn.createdAt)
            val data = dataKkn.content
            tvDescDetail.text = Html.fromHtml(data)
            btnNews.visibility = View.GONE

            Glide.with(this@DetailActivity)
                .load(dataKkn.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.image_load)
                .into(imgReport)
        }
    }

    private fun populateNews(dataNews: News) {
        binding.run {
            tvNameDetail.text = dataNews.title
            tvDateTimeLoc.text = DataMapper.newsDateFormatter(dataNews.date)
            tvDescDetail.text = dataNews.desc
            btnNews.setOnClickListener {
                val urlIntent = Intent(Intent.ACTION_VIEW)
                urlIntent.data = Uri.parse(dataNews.url)
                startActivity(urlIntent)
            }

            Glide.with(this@DetailActivity)
                .load(dataNews.image)
                .centerCrop()
                .placeholder(R.drawable.image_load)
                .into(imgReport)
        }
    }

    companion object {
        const val EXTRA_KKN = "EXTRA_KKN"
        const val EXTRA_NEWS = "EXTRA_NEWS"
    }
}