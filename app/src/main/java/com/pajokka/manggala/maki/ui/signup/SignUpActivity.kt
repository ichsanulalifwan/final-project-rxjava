package com.pajokka.manggala.maki.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.pajokka.manggala.maki.ui.MainActivity
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.model.User
import com.pajokka.manggala.maki.ui.signin.SignInActivity
import com.pajokka.manggala.maki.utils.Preferences
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_home
import kotlinx.android.synthetic.main.activity_sign_up.et_password
import kotlinx.android.synthetic.main.activity_sign_up.et_email
import kotlinx.android.synthetic.main.activity_sign_up.progressBar

class SignUpActivity : AppCompatActivity() {

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var preferences: Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mFirebaseDatabase = mFirebaseInstance.getReference("User")
        auth = FirebaseAuth.getInstance()
        preferences = Preferences(this)

        btn_home.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val sNama = et_nama.text.toString()
            val sEmail = et_email.text.toString()
            val sPassword = et_password.text.toString()

            if (sNama.isEmpty() || sNama == "") {
                et_nama.error = "Silakan isi nama anda"
                et_nama.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sEmail.isEmpty() || sEmail == "") {
                et_email.error = "Silakan isi email anda"
                et_email.requestFocus()
                progressBar.visibility = View.GONE
            } else if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                et_email.error = "Format email anda salah"
                et_email.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sPassword.isEmpty() || sPassword == "") {
                et_password.error = "Silakan isi kata sandi anda"
                et_password.requestFocus()
                progressBar.visibility = View.GONE
            } else if (sPassword.length < 6) {
                et_password.error = "Sandi minimal 6 karakter"
                progressBar.visibility = View.GONE
            } else {
                saveUser(sEmail, sPassword, sNama)
            }
        }

        imageView3.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            finish()
        }
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
                    Toast.makeText(this@SignUpActivity, "Selamat Datang $sNama", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                    finishAffinity()
                } else {
                    Toast.makeText(this@SignUpActivity, "Registrasi akun gagal", Toast.LENGTH_LONG)
                        .show()
                    progressBar.visibility = View.GONE
                }
            }
    }
}