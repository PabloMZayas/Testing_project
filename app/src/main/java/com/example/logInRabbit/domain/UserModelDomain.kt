package com.example.logInRabbit.domain

import java.util.*

data class UserModelDomain (
    var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var birthday: String = "",
    var description: String = "",
)
