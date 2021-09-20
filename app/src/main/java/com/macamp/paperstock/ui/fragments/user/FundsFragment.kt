package com.macamp.paperstock.ui.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.macamp.paperstock.databinding.FundsFragmentBinding

class FundsFragment : Fragment() {

    companion object {
        fun newInstance() = FundsFragment()
    }

    private lateinit var viewModel: FundsViewModel
    private lateinit var binding: FundsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FundsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}