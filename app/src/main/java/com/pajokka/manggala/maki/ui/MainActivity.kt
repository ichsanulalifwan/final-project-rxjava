package com.pajokka.manggala.maki.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.github.dhaval2404.imagepicker.ImagePicker
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.ui.report.ReportActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        floating_button_camera.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() = launch {
        withContext(Dispatchers.IO) {
            ImagePicker.with(this@MainActivity)
                .cameraOnly()
                .compress(1024)
                .maxResultSize(620, 620)
                .start(ReportActivity.CAMERA_IMAGE_REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri = data?.data!!
            when (requestCode) {
                ReportActivity.CAMERA_IMAGE_REQ_CODE -> {
                    startActivity(Intent(this, ReportActivity::class.java).putExtra("URI", uri))
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
    }
}