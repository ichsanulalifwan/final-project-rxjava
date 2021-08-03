package com.pajokka.manggala.maki.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.pajokka.manggala.maki.ui.MainActivity
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.model.Kkn
import com.pajokka.manggala.maki.model.News
import com.pajokka.manggala.maki.utils.DataMapper
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iv_back.setOnClickListener {
            startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            finish()
        }

        val getDataKKN = intent.getParcelableExtra<Kkn>(EXTRA_KKN)
        val getDataNews = intent.getParcelableExtra<News>(EXTRA_NEWS)

        if (getDataKKN != null) {
            populateKKN(getDataKKN)
        } else if (getDataNews != null) {
            populateNews(getDataNews)
        }
    }

    private fun populateKKN(dataKkn: Kkn) {
        tv_name_detail.text = dataKkn.title
        tv_date_time_loc.text = DataMapper.kknDateFormatter(dataKkn.createdAt)
        val data = dataKkn.content
        tv_desc_detail.text = Html.fromHtml(data)
        btn_news.visibility = View.GONE

        Glide.with(this@DetailActivity)
            .load(dataKkn.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.image_load)
            .into(img_report)
    }

    private fun populateNews(dataNews: News) {
        tv_name_detail.text = dataNews.title
        tv_date_time_loc.text = DataMapper.newsDateFormatter(dataNews.date)
        tv_desc_detail.text = dataNews.desc
        btn_news.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse(dataNews.url)
            startActivity(urlIntent)
        }

        Glide.with(this@DetailActivity)
            .load(dataNews.image)
            .centerCrop()
            .placeholder(R.drawable.image_load)
            .into(img_report)
    }

    companion object {
        const val EXTRA_KKN = "EXTRA_KKN"
        const val EXTRA_NEWS = "EXTRA_NEWS"
    }
}