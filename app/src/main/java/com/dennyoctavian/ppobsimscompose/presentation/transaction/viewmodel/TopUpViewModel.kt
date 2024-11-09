package com.dennyoctavian.ppobsimscompose.presentation.transaction.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.TopUpRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BalanceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopUpViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    private val _topUpState =
        MutableStateFlow<NetworkResult<BalanceResponse>>(NetworkResult.Loading)
    val topUpState: StateFlow<NetworkResult<BalanceResponse>> = _topUpState

    fun topUp(amount: Long) {
        _topUpState.value = NetworkResult.Loading
        viewModelScope.launch {
            _topUpState.value = transactionRepository.topUp(
                TopUpRequest(
                    amount
                )
            )
        }
    }
}