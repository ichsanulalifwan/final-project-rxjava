package com.app.ichsanulalifwan.barani.ui.profil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.ichsanulalifwan.barani.R
import com.app.ichsanulalifwan.barani.databinding.FragmentProfilBinding
import com.app.ichsanulalifwan.barani.ui.signin.SignInActivity
import com.app.ichsanulalifwan.barani.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.auth.FirebaseAuth

class ProfilFragment : Fragment() {

    private lateinit var profilViewModel: ProfilViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var preferences: Preferences
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        profilViewModel =
            ViewModelProvider(this)[ProfilViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferences = Preferences(requireContext().applicationContext)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.run {
            t2.text = preferences.getValues("email")
            t3.text = preferences.getValues("nama")

            if (preferences.getValues("type").equals("1")) {
                btnLogout.setOnClickListener {
                    preferences.setValues("status", "0")
                    firebaseAuth.signOut()
                    checkUser()
                }
            } else if (preferences.getValues("type").equals("2")) {
                val firebaseUser = firebaseAuth.currentUser

                if (firebaseUser != null) {
                    Glide.with(this@ProfilFragment)
                        .load(firebaseUser.photoUrl)
                        .centerCrop()
                        .placeholder(R.drawable.user_account)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imgUser)
                }

                btnLogout.setOnClickListener {
                    preferences.setValues("status", "0")
                    firebaseAuth.signOut()
                    checkUser()
                }
            }
        }
    }

    private fun checkUser() {
        if (firebaseAuth.currentUser == null) {
            startActivity(Intent(context, SignInActivity::class.java))
            activity?.finishAffinity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}