package com.dennyoctavian.ppobsimscompose.domain.repository

import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BannerResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ServiceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult

interface InformationRepository {
    suspend fun getBanner(): NetworkResult<ArrayList<BannerResponse>>
    suspend fun getService(): NetworkResult<ArrayList<ServiceResponse>>
}