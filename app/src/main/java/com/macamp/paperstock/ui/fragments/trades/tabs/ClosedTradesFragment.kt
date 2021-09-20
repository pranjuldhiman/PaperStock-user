package com.macamp.paperstock.ui.fragments.trades.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.macamp.paperstock.adapter.ClosedTradesAdapter
import com.macamp.paperstock.databinding.ClosedTradesFragmentBinding

class ClosedTradesFragment : Fragment() {

    companion object {
        fun newInstance() = ClosedTradesFragment()
    }

    private lateinit var viewModel: ClosedTradesViewModel
    private lateinit var binding: ClosedTradesFragmentBinding
    private lateinit var closedAdapter: ClosedTradesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ClosedTradesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        closedAdapter = ClosedTradesAdapter(requireContext())
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = closedAdapter
        }
    }

}