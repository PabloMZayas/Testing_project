package com.example.logInRabbit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logInRabbit.di.CoroutinesDispatchers
import com.example.logInRabbit.domain.UserModelDomain
import com.example.logInRabbit.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    private var _infoUser = MutableLiveData<UserModelDomain>()
    val infoState get() = _infoUser


    fun saveUser(name: String, lastName: String) {
        val newUser = UserModelDomain(
            name = name,
            lastName = lastName
        )

        viewModelScope.launch(coroutinesDispatchers.io) {
            withContext(coroutinesDispatchers.main) {
                userRepository.insertUser(newUser)
            }
        }
    }
}