package com.dennyoctavian.ppobsimscompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ServiceResponse(
    @SerializedName("service_code") val serviceCode: String,
    @SerializedName("service_name") val serviceName: String,
    @SerializedName("service_icon") val serviceIcon: String,
    @SerializedName("service_tariff") val serviceTariff: Long
)

