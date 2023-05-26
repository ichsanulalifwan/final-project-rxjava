package com.app.ichsanulalifwan.barani.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.ichsanulalifwan.barani.core.model.Kkn
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.viewmodel.BerandaViewModel
import com.app.ichsanulalifwan.barani.databinding.ListFragmentBinding
import com.app.ichsanulalifwan.barani.ui.adapter.KknListAdapter
import com.app.ichsanulalifwan.barani.ui.adapter.ListAdapter
import com.app.ichsanulalifwan.barani.utils.DataMapper
import com.google.firebase.database.*

class ListFragment : Fragment() {

    private lateinit var berandaViewModel: BerandaViewModel
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsAdapter: ListAdapter
    private lateinit var kknListAdapter: KknListAdapter
    private val args by navArgs<ListFragmentArgs>()
    private lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Kkn>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        berandaViewModel =
            ViewModelProvider(this)[BerandaViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            binding.listShimmer.visibility = View.VISIBLE

            val category = args.type

            mDatabase = FirebaseDatabase.getInstance().getReference("Entry")

            when (category) {
                1 -> {
                    newsAdapter = ListAdapter()
                    setupNewsRecyclerView()
                    setNews()
                }
                2 -> {
                    kknListAdapter = KknListAdapter()
                    setupKknRecyclerView()
                    getData()
                }
                else -> Toast.makeText(context, "Terdapat Error", Toast.LENGTH_SHORT).show()
            }

            binding.ivBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupNewsRecyclerView() {
        with(binding.rvList) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = newsAdapter
        }
    }

    private fun setupKknRecyclerView() {
        with(binding.rvList) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = kknListAdapter
        }
    }

    private fun setNews() {
        berandaViewModel.getLatestNews().observe(viewLifecycleOwner) {
            val newsList = DataMapper.mapResponseToModel(it)
            newsAdapter.setData(newsList as ArrayList<News>)
            binding.listShimmer.visibility = View.GONE
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in dataSnapshot.children) {
                    val data = getdataSnapshot.getValue(Kkn::class.java)
                    dataList.add(data!!)
                    kknListAdapter.setData(dataList)
                    binding.listShimmer.visibility = View.GONE
                }

                Log.d(context.toString(), "Ini mi: $dataList")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}