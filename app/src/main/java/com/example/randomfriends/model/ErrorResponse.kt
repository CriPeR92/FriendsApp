package com.example.randomfriends.model

import com.google.gson.annotations.SerializedName

/**
 * Model to manage error Response from services
 */

class Error(@SerializedName("messages") var data: ArrayList<ErrorMessages>)

class ErrorMessages(
    @SerializedName("code") var code: String,
    @SerializedName("message") var message: String,
    @SerializedName("userMessage") var userMessage: String,
    @SerializedName("useApiMessage") var useApiMessage: Boolean,
    @SerializedName("type") var type: String
)