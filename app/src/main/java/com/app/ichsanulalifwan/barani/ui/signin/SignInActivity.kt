package com.app.ichsanulalifwan.barani.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.*
import com.app.ichsanulalifwan.barani.R
import com.app.ichsanulalifwan.barani.ui.MainActivity
import com.app.ichsanulalifwan.barani.ui.signup.SignUpActivity
import com.app.ichsanulalifwan.barani.model.User
import com.app.ichsanulalifwan.barani.utils.Preferences
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()
        databaseReference = mDatabase.reference.child("User")
        checkUser()

        btn_googleSignIn.setOnClickListener {
            // SignIn with Google Account
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        preferences = Preferences(this)

        preferences.setValues("onboarding", "1")
        if (preferences.getValues("status").equals("1")) {
            finishAffinity()

            val intent = Intent(
                this@SignInActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            progressBar.visibility = View.GONE
        }

        btn_home.setOnClickListener {
            val iEmail = et_username.text.toString()
            val iPassword = et_password.text.toString()

            progressBar.visibility = View.VISIBLE

            if (iEmail.isEmpty() || iEmail == "") {
                et_username.error = "Silakan isi email anda"
                et_username.requestFocus()
                progressBar.visibility = View.GONE
            } else if (iPassword.isEmpty() || iPassword == "") {
                et_password.error = "Silakan isi kata sandi anda"
                et_password.requestFocus()
                progressBar.visibility = View.GONE
            } else {
                pushLogin(iEmail, iPassword)
            }
        }

        btn_daftar.setOnClickListener {
            val intent = Intent(
                this@SignInActivity,
                SignUpActivity::class.java
            )
            startActivity(intent)
        }
    }

    private fun checkUser() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(
                this@SignInActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finishAffinity()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(
                    this@SignInActivity,
                    "Masuk dengan Google gagal",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                Log.d(TAG, "signInWithCredential:success")
                val user = auth.currentUser
                val userName = user?.displayName
                val email = user?.email

                if (email != null) {
                    preferences.setValues("email", email)
                }
                if (userName != null) {
                    preferences.setValues("nama", userName)
                }
                preferences.setValues("status", "1")
                preferences.setValues("type", "2")

                if (authResult.additionalUserInfo!!.isNewUser) {
                    Toast.makeText(
                        this@SignInActivity,
                        "Selamat Datang $userName",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@SignInActivity,
                        "Selamat Datang Kembali $userName",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                val intent = Intent(
                    this@SignInActivity,
                    MainActivity::class.java
                )
                startActivity(intent)
                finishAffinity()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    this@SignInActivity,
                    "Terdapat kesalahan dikarenakan ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun pushLogin(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    val userReference = databaseReference.child(user?.uid!!)

                    userReference.addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val userData = dataSnapshot.getValue(User::class.java)
                            if (userData != null) {
                                preferences.setValues("email", userData.email.toString())
                            }
                            if (userData != null) {
                                preferences.setValues("nama", userData.nama.toString())
                                Toast.makeText(
                                    this@SignInActivity,
                                    "Selamat Datang Kembali ${userData.nama}",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    this@SignInActivity,
                                    "Selamat Datang Kembali",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            preferences.setValues("status", "1")
                            preferences.setValues("type", "1")
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(
                                this@SignInActivity,
                                "" + error.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    })

                    progressBar.visibility = View.GONE
                    val intent = Intent(
                        this@SignInActivity,
                        MainActivity::class.java
                    )
                    startActivity(intent)
                    finishAffinity()
                } else {
                    Toast.makeText(
                        this@SignInActivity,
                        "Email atau sandi anda salah, silakan coba kembali",
                        Toast.LENGTH_LONG
                    ).show()
                    progressBar.visibility = View.GONE
                }
            }
    }

    companion object {
        private const val RC_SIGN_IN = 100
        private const val TAG = "SignIn"
    }
}