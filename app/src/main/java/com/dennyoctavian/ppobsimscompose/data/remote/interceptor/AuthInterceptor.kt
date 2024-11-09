package com.dennyoctavian.ppobsimscompose.data.remote.interceptor

import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.local.preferences.TokenProvider
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import dagger.Lazy
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider,
    private val membershipRepository: Lazy<MembershipRepository>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val accessToken = tokenProvider.getAccessToken()

        // Add Authorization header
        request = request.newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
            .build()

        // Execute the request
        var response = chain.proceed(request)

        // Retry logic if unauthorized (401)
        if (response.code == 401) {
            synchronized(this) { // Ensure thread safety
                // Attempt to refresh the token
                if (tokenProvider.getRefreshToken()?.isNotEmpty() == true) {
                    // Retry the request with the new token
                    val newAccessToken = runBlocking {
                        // Refresh the token
                        membershipRepository.get().refreshToken()
                        // membershipRepository.get().refreshToken()
                    }
                    request = request.newBuilder()
                        .removeHeader("Authorization")
                        .addHeader(
                            "Authorization",
                            "Bearer ${(newAccessToken as NetworkResult.Success).data?.accessToken}"
                        )
                        .build()
                    response.close() // Close previous response
                    response = chain.proceed(request) // Retry request
                } else {
                    // Clear token if refresh fails
                    tokenProvider.clearToken()
                }
            }
        }

        return response
    }
}
