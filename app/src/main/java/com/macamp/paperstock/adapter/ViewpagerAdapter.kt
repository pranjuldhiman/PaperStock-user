package com.macamp.paperstock.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.macamp.paperstock.ui.fragments.dashboard.tabs.mcxFutures.MCXFutureFragment
import com.macamp.paperstock.ui.fragments.dashboard.tabs.nseFutures.NSEFragment

class ViewpagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {


        val fragment: Fragment = when (position) {
            0 -> MCXFutureFragment()
            1 -> NSEFragment()
            else -> MCXFutureFragment()
        }

//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
        return fragment
    }
}