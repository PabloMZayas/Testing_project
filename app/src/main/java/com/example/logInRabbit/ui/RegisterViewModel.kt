package com.example.logInRabbit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logInRabbit.di.CoroutinesDispatchers
import com.example.logInRabbit.domain.UserModelDomain
import com.example.logInRabbit.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    var user = UserModelDomain()

    private var _showToast = MutableLiveData(0)
    val showToast get() = _showToast


    fun validateName(name: String, lastName: String) {
        if(name.isEmpty() || lastName.isEmpty()){
            _showToast.value = 1
            return
        }

        if(name.length<3) {
            _showToast.value = 2
            return
        }

        if (lastName.length<3) {
            _showToast.value = 3
            return
        }

        _showToast.value = 10
        user.name = name
        user.lastName = lastName
    }

    fun validateBirthDay(date: String) {
       user.birthday = date
    }

    fun validateCredentials(email: String, password: String) {
        user.email = email
        user.password = password
        initRegister(user)
    }

    private fun initRegister(user: UserModelDomain) {
        viewModelScope.launch(coroutinesDispatchers.io) {
                userRepository.insertUser(user)
        }
    }
}