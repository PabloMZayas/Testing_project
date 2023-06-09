package com.example.logInRabbit.ui.selectmode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.FragmentSelectModeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectModeFragment : Fragment(){

    private var _binding: FragmentSelectModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectModeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_selectModeFragment_to_playing1AllEquipment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}