package com.dennyoctavian.ppobsimscompose.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.dennyoctavian.ppobsimscompose.domain.local.preferences.TokenProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesTokenProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : TokenProvider {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences("token_prefs", Context.MODE_PRIVATE)
    }

    override fun getAccessToken(): String? = preferences.getString("access_token", null)

    override fun saveAccessToken(newToken: String) {
        preferences.edit().putString("access_token", newToken).apply()
    }

    override fun getRefreshToken(): String? = preferences.getString("refresh_token", null)

    override fun saveRefreshToken(newToken: String) {
        preferences.edit().putString("refresh_token", newToken).apply()
    }

    override fun clearToken() {
        preferences.edit().clear().apply()
    }
}
