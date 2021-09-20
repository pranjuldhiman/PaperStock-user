package com.macamp.paperstock.ui.fragments.trades.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.macamp.paperstock.adapter.PendingActiveTradesAdapter
import com.macamp.paperstock.databinding.ActiveTradesFragmentBinding

class ActiveTradesFragment : Fragment() {

    companion object {
        fun newInstance() = ActiveTradesFragment()
    }

    private lateinit var viewModel: ActiveTradesViewModel

    private lateinit var binding: ActiveTradesFragmentBinding
    private lateinit var activeAdapter: PendingActiveTradesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ActiveTradesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        activeAdapter = PendingActiveTradesAdapter(requireContext())
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = activeAdapter
        }
    }
}