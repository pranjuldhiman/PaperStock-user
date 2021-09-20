package com.macamp.paperstock.ui.fragments.trades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.macamp.paperstock.adapter.TradesPagerAdapter
import com.macamp.paperstock.databinding.TradesFragmentBinding

class TradesFragment : Fragment() {


    private lateinit var binding: TradesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = TradesFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewpager()
    }

    private fun setupViewpager() {
        binding.viewPager.apply {
            adapter = TradesPagerAdapter(this@TradesFragment)
        }
        TabLayoutMediator(binding.tabView, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Pending"
                }
                1 -> {
                    tab.text = "Active"
                }
                2 -> {
                    tab.text = "Closed"
                }
            }

        }.attach()
    }

}