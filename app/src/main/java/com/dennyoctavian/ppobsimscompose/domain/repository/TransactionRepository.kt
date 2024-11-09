package com.dennyoctavian.ppobsimscompose.domain.repository

import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TopUpRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TransactionRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BalanceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionHistoryResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult

interface TransactionRepository {
    suspend fun getBalance():
            NetworkResult<BalanceResponse>

    suspend fun getTransactionHistory(offset: Int, limit: Int):
            NetworkResult<ArrayList<TransactionHistoryResponse>>

    suspend fun topUp(topUpRequest: TopUpRequest):
            NetworkResult<BalanceResponse>

    suspend fun transaction(transactionRequest: TransactionRequest):
            NetworkResult<TransactionResponse>
}