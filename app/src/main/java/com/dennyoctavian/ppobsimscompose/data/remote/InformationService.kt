package com.dennyoctavian.ppobsimscompose.data.remote

import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BannerResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ServiceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.ApiResponseWrapper
import retrofit2.Response
import retrofit2.http.GET

interface InformationService {
    @GET("banner")
    suspend fun getBanner(): Response<ApiResponseWrapper<ArrayList<BannerResponse>>>

    @GET("service")
    suspend fun getService(): Response<ApiResponseWrapper<ArrayList<ServiceResponse>>>
}