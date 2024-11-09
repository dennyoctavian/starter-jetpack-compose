package com.dennyoctavian.ppobsimscompose.data.remote.model.response.base

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T?) : NetworkResult<T>()
    data class Error(val status: Int, val message: String) : NetworkResult<Nothing>()
    data object Loading : NetworkResult<Nothing>()
    data object LoadingMore : NetworkResult<Nothing>()
}

