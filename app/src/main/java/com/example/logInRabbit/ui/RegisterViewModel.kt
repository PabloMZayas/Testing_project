package com.example.logInRabbit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logInRabbit.domain.UserRepository
import com.example.logInRabbit.ui.utils.InfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(userRepository: UserRepository)
    : ViewModel() {

    private var _infoState = MutableLiveData<InfoState>()
    val infoState get() = _infoState

    private fun validateName (name: String, lastName: String){
        if (name.length>3 && lastName.length>3) _infoState.value?.isAcceptedName = true
    }
}