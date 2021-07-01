package com.example.randomfriends.data.retrofit

import com.example.randomfriends.model.FriendsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/")
    suspend fun getFriends(
        @Query("page") page: Int = 1,
        @Query("results") results: Int = 10,
        @Query("seed") seed: String = "abc"
    ): Response<FriendsResponse>
}