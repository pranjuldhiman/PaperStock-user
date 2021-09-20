package com.macamp.paperstock.ui.fragments.dashboard.tabs.nseFutures

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macamp.paperstock.R

class NSEFragment : Fragment() {

    companion object {
        fun newInstance() = NSEFragment()
    }

    private lateinit var viewModel: NSEViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.nse_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NSEViewModel::class.java)
        // TODO: Use the ViewModel
    }

}