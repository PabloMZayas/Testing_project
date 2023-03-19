package com.example.logInRabbit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.FragmentPlaying1AllEquipmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Playing1AllEquipment : DialogFragment(){

    private var _binding: FragmentPlaying1AllEquipmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaying1AllEquipmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            Toast.makeText(requireContext(), "Check_Selection", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}