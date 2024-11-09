package com.dennyoctavian.ppobsimscompose.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class RefreshRequest(
    @SerializedName("refresh_token") val refreshToken: String
)
