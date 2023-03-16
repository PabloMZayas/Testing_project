package com.example.logInRabbit.ui

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.databinding.FragmentCredentialsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class CredentialsFragment : Fragment() {
    private var _binding: FragmentCredentialsBinding? = null
    private val binding get() = _binding!!

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCredentialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ibBack.setOnClickListener{ findNavController().popBackStack() }
        binding.btnRegister.setOnClickListener { verifyEmailAndPassword() }
    }

    private fun verifyEmailAndPassword() {
        val email = binding.textInputEmail.text.toString()
        val password = binding.textInputPassword.text.toString()
        val verifyPassword = binding.textInputConfirmPassword.text.toString()

        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        if(!pattern.matcher(email).matches()) {
            Toast.makeText(requireContext(), "Ingresa un correo válido", Toast.LENGTH_SHORT).show()
            return
        }

        if(password.length<7){
            Toast.makeText(requireContext(), "La constraseña debe contener al menos 7 caracteres", Toast.LENGTH_SHORT).show()
            return
        }

        if(password!=verifyPassword){
            Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        registerViewModel.validateCredentials(email, password)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}