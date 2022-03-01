package com.example.api_activity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckService {
    @GET("random")
    fun getDuck() : Call<duck>
}