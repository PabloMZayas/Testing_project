package com.example.logInRabbit.domain

import com.example.logInRabbit.data.UserDao
import com.example.logInRabbit.data.toUserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: UserModelDomain) = userDao.insertUser(user.toUserEntity())
}
