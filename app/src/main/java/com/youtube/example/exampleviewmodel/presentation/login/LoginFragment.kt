package com.youtube.example.exampleviewmodel.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.youtube.example.exampleviewmodel.R

class LoginFragment : Fragment() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view)
        setupViewModel()
    }
    private fun setup(view: View) {
        etUsername = view.findViewById(R.id.etUsername)
        etPassword = view.findViewById(R.id.etPassword)
        btLogin = view.findViewById(R.id.btLogin)
        btLogin.setOnClickListener {
            viewModel.login(etUsername.text.toString(), etPassword.text.toString())
        }
    }
    private fun setupViewModel() {
        viewModel.loginResultLD.observe(viewLifecycleOwner) { success ->
            if (success) {
                val bundle = Bundle()
                bundle.putString("userID", "3ad50gfbcdbu")
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            } else {
                view?.also {
                    val snack = Snackbar.make(it, "El usuario o contraseña no es correcto", Snackbar.LENGTH_LONG)
                    snack.show()
                }
            }
        }
    }
}