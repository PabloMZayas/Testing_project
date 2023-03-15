package com.example.logInRabbit.ui

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.FragmentSignNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignNameFragment : Fragment(){

    private var _binding: FragmentSignNameBinding? = null
    private val binding get() = _binding!!

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initObservers()

        binding.tvDoYouAlreadyHaveAnAccount.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        binding.ibBack.setOnClickListener { findNavController().navigate(R.id.action_signInFragment_to_snakeMainFragment) }

        binding.tvDoYouAlreadyHaveAnAccount.setOnClickListener { findNavController().navigate(R.id.action_signInFragment_to_snakeMainFragment) }

        binding.btnNext.setOnClickListener {
            val name = binding.textFieldName.text.toString()
            val lastName = binding.textFieldLastName.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Ingresa un nombre válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                Toast.makeText(requireContext(), "Ingresa un apellido válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registerViewModel.saveUser(name, lastName)
            findNavController().navigate(R.id.action_signInFragment_to_signBirthdayFragment)
        }
    }

    private fun initObservers() {
        registerViewModel.infoState.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}