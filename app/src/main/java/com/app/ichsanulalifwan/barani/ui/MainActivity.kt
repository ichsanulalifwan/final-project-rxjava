package com.app.ichsanulalifwan.barani.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.app.ichsanulalifwan.barani.R
import com.app.ichsanulalifwan.barani.databinding.ActivityMainBinding
import com.app.ichsanulalifwan.barani.ui.report.ReportActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // prevent dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup the bottom navigation view with navController
        val bottomNavigationView: BottomAppBar = binding.navView

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.apply {
            background = null
            menu.getItem(1).isEnabled = false
        }

        binding.floatingButtonCamera.setOnClickListener {
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

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
    }
}