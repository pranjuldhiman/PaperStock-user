package com.macamp.paperstock.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.macamp.paperstock.ui.fragments.trades.tabs.ActiveTradesFragment
import com.macamp.paperstock.ui.fragments.trades.tabs.ClosedTradesFragment
import com.macamp.paperstock.ui.fragments.trades.tabs.PendingTradesFragment

class TradesPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {


        val fragment: Fragment = when (position) {
            0 -> PendingTradesFragment()
            1 -> ActiveTradesFragment()
            2 -> ClosedTradesFragment()
            else-> PendingTradesFragment()
        }

//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
        return fragment
    }
}