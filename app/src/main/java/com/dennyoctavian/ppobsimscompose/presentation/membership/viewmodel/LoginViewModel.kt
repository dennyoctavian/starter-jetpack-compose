package com.dennyoctavian.ppobsimscompose.presentation.membership.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.LoginRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.LoginResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val membershipRepository: MembershipRepository
) : ViewModel() {
    private val _loginState = MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Loading)
    val loginState: StateFlow<NetworkResult<LoginResponse>> = _loginState

    fun login(email: String, password: String) {
        _loginState.value = NetworkResult.Loading
        viewModelScope.launch {
            _loginState.value = membershipRepository.login(
                LoginRequest(
                    email,
                    password
                )
            )
        }
    }
}