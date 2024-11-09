package com.dennyoctavian.ppobsimscompose.presentation.membership.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ProfileResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val membershipRepository: MembershipRepository
) : ViewModel() {
    private val _userState = MutableStateFlow<NetworkResult<ProfileResponse>>(NetworkResult.Loading)
    val userState: StateFlow<NetworkResult<ProfileResponse>> = _userState

    fun getProfile() {
        _userState.value = NetworkResult.Loading
        viewModelScope.launch {
            _userState.value = membershipRepository.getProfile()
        }
    }
}