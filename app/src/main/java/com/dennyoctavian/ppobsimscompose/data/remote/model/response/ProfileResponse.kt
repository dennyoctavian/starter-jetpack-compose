package com.dennyoctavian.ppobsimscompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("profile_image") val profileImage: String
)
