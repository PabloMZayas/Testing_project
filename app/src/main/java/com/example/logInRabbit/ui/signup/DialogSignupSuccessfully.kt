package com.example.logInRabbit.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.DialogSignupSuccessfullyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DialogSignupSuccessfully : DialogFragment(){

    private var _binding: DialogSignupSuccessfullyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogSignupSuccessfullyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccept.setOnClickListener {
            findNavController().navigate(R.id.action_dialogSignupSuccessfully_to_selectModeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}