package com.dennyoctavian.ppobsimscompose.presentation.transaction.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TransactionRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.TransactionResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    private val _transactionState =
        MutableStateFlow<NetworkResult<TransactionResponse>>(NetworkResult.Loading)
    val transactionState: StateFlow<NetworkResult<TransactionResponse>> = _transactionState

    fun transaction(serviceCode: String) {
        _transactionState.value = NetworkResult.Loading
        viewModelScope.launch {
            _transactionState.value = transactionRepository.transaction(
                TransactionRequest(serviceCode)
            )
        }
    }
}