package com.example.logInRabbit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.logInRabbit.databinding.LoggedFragmentBinding
import com.example.logInRabbit.jsons.UsersItem

class LoggedFragmentFragment : Fragment(){

    private var _binding: LoggedFragmentBinding? = null
    private val binding get() = _binding!!
    //private val args: LoggedFragmentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoggedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val user: UsersItem = requireArguments().getParcelable("user")!!
        binding.welcome.text = "Welcome back, ${user.name}"
        binding.userId.text = "Id: ${user.id}"
        binding.phone.text = "Phone: ${user.phone}"
        binding.email.text = "Email: ${user.email}"
        binding.city.text = "City: ${user.address.city}"
        binding.suite.text = "Suite: ${user.address.suite}"
        binding.street.text = "Street: ${user.address.street}"
        binding.website.text = user.website
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
