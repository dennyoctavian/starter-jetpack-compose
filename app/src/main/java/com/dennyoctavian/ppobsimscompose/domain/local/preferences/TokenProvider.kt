package com.dennyoctavian.ppobsimscompose.domain.local.preferences

interface TokenProvider {
    fun getAccessToken(): String?
    fun saveAccessToken(newToken: String)
    fun getRefreshToken(): String?
    fun saveRefreshToken(newToken: String)
    fun clearToken()
}
