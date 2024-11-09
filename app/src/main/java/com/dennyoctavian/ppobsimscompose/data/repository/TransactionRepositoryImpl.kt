package com.dennyoctavian.ppobsimscompose.data.repository

import com.dennyoctavian.ppobsimscompose.data.remote.TransactionService
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TopUpRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TransactionRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BalanceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionHistoryResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.TransactionRepository
import com.dennyoctavian.ppobsimscompose.utils.handleException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImpl @Inject constructor(
    private val transactionService: TransactionService
) : TransactionRepository {
    override suspend fun getBalance(): NetworkResult<BalanceResponse> {
        return try {
            val response = transactionService.getBalance()

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
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

    override suspend fun getTransactionHistory(
        offset: Int,
        limit: Int
    ): NetworkResult<ArrayList<TransactionHistoryResponse>> {
        return try {
            val response = transactionService.getTransactionHistory(
                offset, limit
            )

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
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

    override suspend fun topUp(topUpRequest: TopUpRequest): NetworkResult<BalanceResponse> {
        return try {
            val response = transactionService.topUp(topUpRequest)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
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

    override suspend fun transaction(transactionRequest: TransactionRequest): NetworkResult<TransactionResponse> {
        return try {
            val response = transactionService.transaction(transactionRequest)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
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