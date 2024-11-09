package com.dennyoctavian.ppobsimscompose.presentation.information.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.BannerResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ServiceResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.repository.InformationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val informationRepository: InformationRepository
) : ViewModel() {
    private val _bannerState =
        MutableStateFlow<NetworkResult<ArrayList<BannerResponse>>>(NetworkResult.Loading)
    val bannerState: StateFlow<NetworkResult<ArrayList<BannerResponse>>> = _bannerState

    private val _serviceState =
        MutableStateFlow<NetworkResult<ArrayList<ServiceResponse>>>(NetworkResult.Loading)
    val serviceState: StateFlow<NetworkResult<ArrayList<ServiceResponse>>> = _serviceState

    fun getBanner() {
        _bannerState.value = NetworkResult.Loading
        viewModelScope.launch {
            _bannerState.value = informationRepository.getBanner()
        }
    }

    fun getServices() {
        _serviceState.value = NetworkResult.Loading
        viewModelScope.launch {
            _serviceState.value = informationRepository.getService()
        }
    }
}
