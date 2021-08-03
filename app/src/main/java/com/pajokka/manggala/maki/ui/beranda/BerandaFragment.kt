package com.pajokka.manggala.maki.ui.beranda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.pajokka.manggala.maki.databinding.FragmentBerandaBinding
import com.pajokka.manggala.maki.model.Kkn
import com.pajokka.manggala.maki.model.News
import com.pajokka.manggala.maki.ui.adapter.DataAdapter
import com.pajokka.manggala.maki.ui.adapter.KknAdapter
import com.pajokka.manggala.maki.utils.DataMapper

class BerandaFragment : Fragment() {

    private lateinit var berandaViewModel: BerandaViewModel
    private lateinit var newsAdapter: DataAdapter
    private lateinit var kknAdapter: KknAdapter
    private lateinit var mDatabase: DatabaseReference
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!
    private var dataList = ArrayList<Kkn>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        berandaViewModel =
            ViewModelProvider(this).get(BerandaViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mDatabase = FirebaseDatabase.getInstance().getReference("Entry")

        if (activity != null) {
            kknAdapter = KknAdapter()
            newsAdapter = DataAdapter()

            getData()
            setNews()

            setupNewsRecyclerView()
            setupKknRecyclerView()

            with(binding) {
                cvItemInfo.setOnClickListener {
                    val urlIntent = Intent(Intent.ACTION_VIEW)
                    urlIntent.data = Uri.parse("https://makassarkota.go.id/makassar-recover/")
                    startActivity(urlIntent)
                }

                textAllNews.setOnClickListener {
                    val action = BerandaFragmentDirections.actionNavigationBerandaToListFragment(1)
                    action.let {
                        findNavController().navigate(it)
                    }
                }

                textAllKkn.setOnClickListener {
                    val action = BerandaFragmentDirections.actionNavigationBerandaToListFragment(2)
                    action.let {
                        findNavController().navigate(it)
                    }
                }

                btnKkn.setOnClickListener {
                    val action = BerandaFragmentDirections.actionNavigationBerandaToListFragment(2)
                    action.let {
                        findNavController().navigate(it)
                    }
                }
            }
        }
    }

    private fun setupNewsRecyclerView() {
        with(binding.rvNews) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = newsAdapter
        }
    }

    private fun setupKknRecyclerView() {
        with(binding.rvKknReport) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = kknAdapter
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in dataSnapshot.children) {
                    val data = getdataSnapshot.getValue(Kkn::class.java)
                    dataList.add(data!!)
                    kknAdapter.setData(dataList)

                    if (dataList.size <= 3 ) {
                        binding.btnKkn.visibility = View.GONE
                    } else {
                        binding.btnKkn.visibility = View.VISIBLE
                    }
                }

                Log.d(context.toString(), "Data : $dataList")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setNews() {
        berandaViewModel.getLatestNews().observe(viewLifecycleOwner, {
            val newsList = DataMapper.mapResponseToModel(it)
            newsAdapter.setData(newsList as ArrayList<News>)
        })

        berandaViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.apply {
                    homeShimmer.visibility = View.VISIBLE
                    rvKknReport.visibility = View.GONE
                    tvNewsHeader.visibility = View.GONE
                    textAllNews.visibility = View.GONE
                    tvKknHeader.visibility = View.GONE
                    textAllKkn.visibility = View.GONE
                    btnKkn.visibility = View.GONE
                }
            } else {
                binding.apply {
                    homeShimmer.visibility = View.GONE
                    rvKknReport.visibility = View.VISIBLE
                    tvNewsHeader.visibility = View.VISIBLE
                    textAllNews.visibility = View.VISIBLE
                    tvKknHeader.visibility = View.VISIBLE
                    textAllKkn.visibility = View.VISIBLE
                    btnKkn.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}