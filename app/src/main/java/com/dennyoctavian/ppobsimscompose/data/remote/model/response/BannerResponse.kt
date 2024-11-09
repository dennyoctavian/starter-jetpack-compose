package com.dennyoctavian.ppobsimscompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class BannerResponse(
    @SerializedName("banner_name") val bannerName: String,
    @SerializedName("banner_image") val bannerImage: String,
    val description: String
)
