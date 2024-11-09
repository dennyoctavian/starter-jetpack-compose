package com.dennyoctavian.ppobsimscompose.data.repository

import com.dennyoctavian.ppobsimscompose.data.remote.InformationService
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BannerResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ServiceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.InformationRepository
import com.dennyoctavian.ppobsimscompose.utils.handleException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InformationRepositoryImpl @Inject constructor(
    private val informationService: InformationService
) : InformationRepository {
    override suspend fun getBanner(): NetworkResult<ArrayList<BannerResponse>> {
        return try {
            val response = informationService.getBanner()

            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!.data
                if (data != null) {
                    return NetworkResult.Success(data)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun getService(): NetworkResult<ArrayList<ServiceResponse>> {
        return try {
            val response = informationService.getService()

            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!.data
                if (data != null) {
                    return NetworkResult.Success(response.body()!!.data)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }
}