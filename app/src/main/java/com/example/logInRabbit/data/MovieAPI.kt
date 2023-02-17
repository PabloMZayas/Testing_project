package com.example.logInRabbit

import com.example.logInRabbit.jsons.UsersItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UsersApi {

    @GET ("users")
    fun getUsers(): Call<List<UsersItem>>

    @GET
    suspend fun getUsers2(@Url url: String) : Response<List<UsersItem>>
}