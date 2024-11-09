package com.dennyoctavian.ppobsimscompose.presentation.membership.viewmodel

import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.RegistrationRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val membershipRepository: MembershipRepository
) : ViewModel() {
    private val _registerState = MutableStateFlow<NetworkResult<Nullable>>(NetworkResult.Loading)
    val registerState: StateFlow<NetworkResult<Nullable>> = _registerState

    fun register(email: String, firstName: String, lastName: String, password: String) {
        _registerState.value = NetworkResult.Loading
        viewModelScope.launch {
            _registerState.value = membershipRepository.register(
                RegistrationRequest(
                    email,
                    firstName,
                    lastName,
                    password,
                )
            )
        }
    }
}