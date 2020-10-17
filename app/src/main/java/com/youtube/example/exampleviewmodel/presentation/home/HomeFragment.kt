package com.youtube.example.exampleviewmodel.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.youtube.example.exampleviewmodel.R

class HomeFragment : Fragment() {
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var ivPerfil: ImageView
    private lateinit var btBirthday: Button
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view)
        setupViewModel()
    }
    private fun setup(view: View) {
        tvNombre = view.findViewById(R.id.tvNombre)
        tvEdad = view.findViewById(R.id.tvEdad)
        ivPerfil = view.findViewById(R.id.ivPerfil)
        btBirthday = view.findViewById(R.id.btBirthday)
        btBirthday.setOnClickListener {
            viewModel.happyBirthday()
        }
    }
    private fun setupViewModel() {
        val userID = arguments?.getString("userID")
        if (userID!=null) {
            //Every Fragment or Activity has their own ViewModelStore and that's why they are a ViewModelStoreOwner
            val vmFactory = HomeVMFactory(userID)
            viewModel = ViewModelProvider(this, vmFactory).get(HomeViewModel::class.java)
            with(viewModel) {
                viewLD.observe(viewLifecycleOwner) {
                    tvNombre.text = it.name
                    tvEdad.text = it.age
                    ivPerfil.setImageResource(it.picture)
                }
            }
        } else {
            //gestionar error
        }
    }
}
