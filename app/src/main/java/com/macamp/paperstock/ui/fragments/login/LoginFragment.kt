package com.macamp.paperstock.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.macamp.paperstock.databinding.LoginFragmentBinding
import com.macamp.paperstock.utils.toast

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    lateinit var binding: LoginFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickEvents()
    }

    private fun clickEvents() {
        binding.loginBtn.setOnClickListener {
          validationCheck()
        }
    }

    private fun validationCheck() {
        when {
            binding.usernameET.text.toString().isEmpty() -> {
                toast("Please enter username")
            }
            binding.passwordET.text.toString().isEmpty() -> {
                toast("Please enter password")
            }
            else -> {
                login(binding.usernameET.text.toString(),binding.passwordET.text.toString())
            }
        }
    }

    private fun login(username: String, password: String) {


    }

}