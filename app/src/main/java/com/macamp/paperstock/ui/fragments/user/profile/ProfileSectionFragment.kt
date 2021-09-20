package com.macamp.paperstock.ui.fragments.user.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macamp.paperstock.R

class ProfileSectionFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileSectionFragment()
    }

    private lateinit var viewModel: ProfileSectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.profile_section_fragment, container, false)
    }


}