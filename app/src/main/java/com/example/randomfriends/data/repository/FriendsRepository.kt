package com.example.randomfriends.data.repository

import com.example.randomfriends.data.retrofit.APIClient
import com.example.randomfriends.data.retrofit.ApiInterface
import com.example.randomfriends.model.FriendsResponse

interface Callback {
    fun onSuccess(response: FriendsResponse)
    fun onFailed(errorResponse: String)
}

class FriendsRepository {

    /**
     * Function getFriends, to get a list of users
     * Response: FriendsResponse
     */

    suspend fun getFriends(
        callback: Callback
    ) {
        val apiInterface = APIClient.getClient()?.create(ApiInterface::class.java)
        val response = apiInterface!!.getFriends()
        if (response.isSuccessful) {
            callback.onSuccess(response.body()!!)
        } else {
            callback.onFailed("error")
        }

    }
}