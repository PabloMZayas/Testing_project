package com.example.logInRabbit

import com.example.logInRabbit.jsons.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {

    @GET ("users")
    fun getUsers(): Call<List<UsersItem>>
}