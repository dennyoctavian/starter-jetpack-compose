package com.dennyoctavian.ppobsimscompose.data.remote

import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TopUpRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TransactionRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BalanceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionHistoryResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.ApiResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TransactionService {
    @GET("balance")
    suspend fun getBalance(): Response<ApiResponseWrapper<BalanceResponse>>

    @GET("transaction/history")
    suspend fun getTransactionHistory(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ApiResponseWrapper<ArrayList<TransactionHistoryResponse>>>

    @POST("topup")
    suspend fun topUp(
        @Body topUpRequest: TopUpRequest
    ): Response<ApiResponseWrapper<BalanceResponse>>

    @POST("transaction")
    suspend fun transaction(
        @Body transactionRequest: TransactionRequest
    ): Response<ApiResponseWrapper<TransactionHistoryResponse>>

}