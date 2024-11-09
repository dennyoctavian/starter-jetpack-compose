package com.dennyoctavian.ppobsimscompose.data.remote.model.response.base

data class ApiResponseWrapper<T>(
    val status: Int,
    val message: String,
    val data: T?
)