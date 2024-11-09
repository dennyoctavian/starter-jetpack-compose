package com.dennyoctavian.ppobsimscompose.utils

import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

fun handleException(e: Exception): NetworkResult.Error {
    return when (e) {
        is SocketTimeoutException -> {
            // Timeout error when the server takes too long to respond
            NetworkResult.Error(90, "Request timed out: ${e.localizedMessage}")
        }

        is UnknownHostException -> {
            // Occurs when the host (server) cannot be resolved (e.g., DNS issues or no internet)
            NetworkResult.Error(91, "No internet connection or DNS error: ${e.localizedMessage}")
        }

        is ConnectException -> {
            // Occurs when the connection to the server fails (e.g., server is down or unreachable)
            NetworkResult.Error(92, "Connection failed: ${e.localizedMessage}")
        }

        is HttpException -> {
            // Specific Retrofit error for HTTP status codes (4xx, 5xx)
            val code = e.code()
            val message = e.message()
            NetworkResult.Error(code, "HTTP error $code: $message")
        }

        is SSLHandshakeException -> {
            // SSL handshake failure (e.g., invalid SSL certificate)
            NetworkResult.Error(93, "SSL handshake failed: ${e.localizedMessage}")
        }

        is JSONException -> {
            // JSON parsing error
            NetworkResult.Error(94, "Error parsing response: ${e.localizedMessage}")
        }

        is InterruptedIOException -> {
            // This error happens when the network operation is interrupted
            NetworkResult.Error(95, "Request interrupted: ${e.localizedMessage}")
        }

        is IllegalStateException -> {
            // Invalid state error, e.g., invalid response type
            NetworkResult.Error(96, "Illegal state error: ${e.localizedMessage}")
        }

        is IOException -> {
            // General network errors like no internet or unreachable host
            NetworkResult.Error(97, "Network error: ${e.localizedMessage}")
        }

        else -> {
            // Handle unexpected exceptions
            NetworkResult.Error(99, "Unknown error: ${e.localizedMessage}")
        }
    }
}
