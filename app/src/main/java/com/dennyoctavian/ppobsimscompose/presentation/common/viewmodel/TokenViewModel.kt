package com.dennyoctavian.ppobsimscompose.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import com.dennyoctavian.ppobsimscompose.domain.local.preferences.TokenProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TokenViewModel @Inject constructor(
    private val tokenProvider: TokenProvider
) : ViewModel() {

    fun getAccessToken(): String? {
        return tokenProvider.getAccessToken()
    }

    fun saveAccessToken(newToken: String) {
        tokenProvider.saveAccessToken(newToken)
    }

    fun getRefreshToken(): String? {
        return tokenProvider.getRefreshToken()
    }

    fun saveRefreshToken(newToken: String) {
        tokenProvider.saveRefreshToken(newToken)
    }

    fun clearToken() {
        tokenProvider.clearToken()
    }
}