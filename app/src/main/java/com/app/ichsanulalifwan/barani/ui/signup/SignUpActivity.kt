package com.app.ichsanulalifwan.barani.ui.signup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.ichsanulalifwan.barani.core.model.User
import com.app.ichsanulalifwan.barani.databinding.ActivitySignUpBinding
import com.app.ichsanulalifwan.barani.ui.MainActivity
import com.app.ichsanulalifwan.barani.ui.signin.SignInActivity
import com.app.ichsanulalifwan.barani.utils.Preferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mFirebaseDatabase = mFirebaseInstance.getReference("User")
        auth = FirebaseAuth.getInstance()
        preferences = Preferences(this)

        initListener()
    }

    private fun initListener() {
        binding.apply {
            btnHome.setOnClickListener {
                validateInputO()
            }

            imageView3.setOnClickListener {
                navigateToSignInPage()
            }
        }
    }


    private fun validateInputO() {
        binding.run {
            progressBar.visibility = View.VISIBLE
            val sNama = etNama.text.toString()
            val sEmail = etEmail.text.toString()
            val sPassword = etPassword.text.toString()

            if (sNama.isEmpty() || sNama == "") {
                etNama.error = "Silakan isi nama anda"
                etNama.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sEmail.isEmpty() || sEmail == "") {
                etEmail.error = "Silakan isi email anda"
                etEmail.requestFocus()
                progressBar.visibility = View.GONE
            } else if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                etEmail.error = "Format email anda salah"
                etEmail.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sPassword.isEmpty() || sPassword == "") {
                etPassword.error = "Silakan isi kata sandi anda"
                etPassword.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sPassword.length < 6) {
                etPassword.error = "Sandi minimal 6 karakter"
                progressBar.visibility = View.GONE
            } else {
                saveUser(sEmail, sPassword, sNama)
            }
        }
    }

    private fun navigateToSignInPage() {
        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        finish()
    }

    private fun saveUser(sEmail: String, sPassword: String, sNama: String) {

        val userData = User()
        userData.nama = sNama
        userData.email = sEmail

        auth.createUserWithEmailAndPassword(sEmail, sPassword)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val currentUsers = auth.currentUser
                    val currentUserDb = mFirebaseDatabase.child((currentUsers?.uid!!))
                    currentUserDb.setValue(userData)

                    preferences.setValues("status", "1")
                    preferences.setValues("type", "1")
                    preferences.setValues("nama", userData.nama.toString())
                    preferences.setValues("email", userData.email.toString())

                    val intent = Intent(
                        this@SignUpActivity,
                        MainActivity::class.java
                    ).putExtra("nama", userData.nama)
                    startActivity(intent)
                    Toast.makeText(this@SignUpActivity, "Selamat Datang $sNama", Toast.LENGTH_SHORT)
                        .show()
                    binding.progressBar.visibility = View.GONE
                    finishAffinity()
                } else {
                    Toast.makeText(this@SignUpActivity, "Registrasi akun gagal", Toast.LENGTH_LONG)
                        .show()
                    binding.progressBar.visibility = View.GONE
                }
            }
    }
}