package com.macamp.paperstock.ui.fragments.dashboard.tabs.mcxFutures

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macamp.paperstock.R

class MCXFutureFragment : Fragment() {

    companion object {
        fun newInstance() = MCXFutureFragment()
    }

    private lateinit var viewModel: MCXFutureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.mcx_future_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MCXFutureViewModel::class.java)
        // TODO: Use the ViewModel
    }

}