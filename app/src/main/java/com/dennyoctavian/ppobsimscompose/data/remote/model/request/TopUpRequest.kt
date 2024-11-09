package com.dennyoctavian.ppobsimscompose.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class TopUpRequest(
    @SerializedName("top_up_amount") val topUpAmount: Long
)

