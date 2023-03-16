package com.example.logInRabbit.ui

import android.app.DatePickerDialog
import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.FragmentSignBithdayBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SignBirthdayFragment : Fragment(){

    private var _binding: FragmentSignBithdayBinding? = null
    private val binding get() = _binding!!

    private lateinit var datePickerDialog: DatePickerDialog
    private var dateValidate = ""

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignBithdayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDatePicker()
        binding.btnDay.setOnClickListener{ datePickerDialog.show()}
        binding.btnMonth.setOnClickListener{ datePickerDialog.show() }
        binding.btnYear.setOnClickListener{ datePickerDialog.show() }
        binding.tvDoYouAlreadyHaveAnAccount.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding.ibBack.setOnClickListener { findNavController().popBackStack() }
        binding.tvDoYouAlreadyHaveAnAccount.setOnClickListener { findNavController().navigate(R.id.action_signBirthdayFragment_to_snakeMainFragment) }
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_signBirthdayFragment_to_credentialsFragment)
            registerViewModel.validateBirthDay(dateValidate)
        }
    }

    private fun initDatePicker() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthI: Int, day: Int ->
                val month = monthI + 1
                dateValidate = dateValidateString(day, month, year)
            }

        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]

        datePickerDialog = DatePickerDialog(requireContext(),R.style.MySpinnerDatePickerStyle, dateSetListener, year, month, day)
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "accept", datePickerDialog)
        datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "cancel", datePickerDialog)
        datePickerDialog = DatePickerDialog(requireContext(), R.style.MySpinnerDatePickerStyle, dateSetListener, year, month, day)
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "accept", datePickerDialog)
        datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "cancel", datePickerDialog)
        datePickerDialog.datePicker.maxDate = cal.timeInMillis
    }

    private fun dateValidateString(day: Int, month: Int, year: Int): String {
        val month2 = if (month < 10) "0$month" else month
        val day2 = if (day < 10) "0$day" else day
        binding.btnDay.text = day2.toString()
        binding.btnMonth.text = month2.toString()
        binding.btnYear.text = year.toString()
        return "$year/$month2/$day2"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}