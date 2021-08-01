package com.pajokka.manggala.maki.ui.profil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.auth.FirebaseAuth
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.ui.signin.SignInActivity
import com.pajokka.manggala.maki.utils.Preferences
import kotlinx.android.synthetic.main.fragment_profil.*

class ProfilFragment : Fragment() {

    private lateinit var profilViewModel: ProfilViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profilViewModel =
            ViewModelProvider(this).get(ProfilViewModel::class.java)
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferences = Preferences(requireContext().applicationContext)

        firebaseAuth = FirebaseAuth.getInstance()

        t2.text = preferences.getValues("email")
        t3.text = preferences.getValues("nama")

        if (preferences.getValues("type").equals("1")) {
            /*t4.text = preferences.getValues("phone")*/

            btn_logout.setOnClickListener {
                preferences.setValues("status", "0")
                firebaseAuth.signOut()
                checkUser()
                /*activity?.finish()
                startActivity(Intent(requireContext(), SignInActivity::class.java))*/
            }
        } else if (preferences.getValues("type").equals("2")) {
            val firebaseUser = firebaseAuth.currentUser

            if (firebaseUser != null) {
                Glide.with(this)
                    .load(firebaseUser.photoUrl)
                    .centerCrop()
                    .placeholder(R.drawable.user_account)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(img_user)
            }

            btn_logout.setOnClickListener {
                preferences.setValues("status", "0")
                firebaseAuth.signOut()
                checkUser()
            }
        }
    }

    private fun checkUser() {
        if (firebaseAuth.currentUser == null) {
            startActivity(Intent(context, SignInActivity::class.java))
            activity?.finish()
        }
    }
}