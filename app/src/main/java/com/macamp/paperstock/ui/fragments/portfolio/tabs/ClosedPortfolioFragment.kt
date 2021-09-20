package com.macamp.paperstock.ui.fragments.portfolio.tabs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macamp.paperstock.R

class ClosedPortfolioFragment : Fragment() {

    companion object {
        fun newInstance() = ClosedPortfolioFragment()
    }

    private lateinit var viewModel: ClosedPortfolioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.closed_portfolio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClosedPortfolioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}