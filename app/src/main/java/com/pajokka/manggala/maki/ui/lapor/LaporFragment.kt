package com.pajokka.manggala.maki.ui.lapor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.FirebaseDatabase
import com.pajokka.manggala.maki.R
import kotlinx.android.synthetic.main.fragment_lapor.*

class LaporFragment : Fragment() {

    private lateinit var laporViewModel: LaporViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        laporViewModel =
                ViewModelProvider(this).get(LaporViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lapor, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        laporViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ini loh
        send.setOnClickListener {
            FirebaseDatabase.getInstance().getReference("Reports").child("Mahasiswa").push().setValue("Ichsan")
        }
    }
}