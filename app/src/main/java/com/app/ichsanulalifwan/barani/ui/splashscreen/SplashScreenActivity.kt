package com.app.ichsanulalifwan.barani.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.ichsanulalifwan.barani.databinding.ActivitySplashScreenBinding
import com.app.ichsanulalifwan.barani.ui.signin.SignInActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val auth = Intent(this, SignInActivity::class.java)
            startActivity(auth)
            finish()
        }, TIME)
    }

    companion object {
        private const val TIME: Long = 3000
    }
}