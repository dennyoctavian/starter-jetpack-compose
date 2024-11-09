package com.dennyoctavian.ppobsimscompose.data.remote.model.request

import com.google.gson.annotations.SerializedName


data class RegistrationRequest(
    val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val password: String
)
