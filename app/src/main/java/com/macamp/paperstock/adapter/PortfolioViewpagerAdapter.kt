package com.macamp.paperstock.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.macamp.paperstock.ui.fragments.portfolio.tabs.ActivePortfolioFragment
import com.macamp.paperstock.ui.fragments.portfolio.tabs.ClosedPortfolioFragment
import com.macamp.paperstock.ui.fragments.trades.tabs.ActiveTradesFragment
import com.macamp.paperstock.ui.fragments.trades.tabs.ClosedTradesFragment

class PortfolioViewpagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        val fragment: Fragment = when (position) {
            0 -> ActivePortfolioFragment()
            1 -> ClosedPortfolioFragment()
            else -> ActivePortfolioFragment()
        }
        return fragment
    }
}