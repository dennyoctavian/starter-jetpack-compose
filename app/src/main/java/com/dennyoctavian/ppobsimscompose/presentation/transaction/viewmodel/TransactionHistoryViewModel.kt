package com.dennyoctavian.ppobsimscompose.presentation.transaction.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionHistoryResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TransactionHistoryViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    private val _transactionHistoryState =
        MutableStateFlow<NetworkResult<ArrayList<TransactionHistoryResponse>>>(NetworkResult.Loading)
    val transactionHistoryState: StateFlow<NetworkResult<ArrayList<TransactionHistoryResponse>>> =
        _transactionHistoryState

    fun getTransactionHistory(offset: Int, limit: Int) {
        _transactionHistoryState.value = NetworkResult.Loading
        viewModelScope.launch {
            if (offset == 0) {
                _transactionHistoryState.value = transactionRepository.getTransactionHistory(
                    offset, limit
                )
            } else {
                transactionRepository.getTransactionHistory(
                    offset, limit
                ).apply {
                    if (this is NetworkResult.Success) {
                        _transactionHistoryState.value.let { currentState ->
                            if (currentState is NetworkResult.Success) {
                                // Retrieve existing data and append new data from this network result
                                val updatedList = currentState.data
                                this.data?.let { newData ->
                                    updatedList?.addAll(newData)
                                }
                                // Emit a new state with the updated list
                                _transactionHistoryState.value = NetworkResult.Success(updatedList)
                            }
                        }
                    }
                }
            }

        }
    }
}