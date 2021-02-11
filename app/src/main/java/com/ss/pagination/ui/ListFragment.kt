package com.ss.pagination.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.ss.pagination.adapter.RecyclerAdapter
import com.ss.pagination.databinding.FragmentListBinding
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        init()
        fetchData()

        return binding.root
    }

    private fun init() {
        adapter = RecyclerAdapter()
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        binding.listRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listRecycler.adapter = adapter
    }

    private fun fetchData() {
        viewModel.getMovies().observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        })
    }
}