package com.dennyoctavian.ppobsimscompose.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class TransactionRequest(
    @SerializedName("service_code") val serviceCode: String,
)
