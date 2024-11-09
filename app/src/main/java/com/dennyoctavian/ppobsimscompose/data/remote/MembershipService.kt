package com.dennyoctavian.ppobsimscompose.data.remote

import androidx.annotation.Nullable
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.LoginRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.ProfileRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.RegistrationRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.LoginResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ProfileResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.RefreshTokenResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.ApiResponseWrapper
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

interface MembershipService {
//    @GET("user/data")
//    suspend fun getUserData(): Response<ResponseApi<Profile>>
//
//    @POST("auth/refresh")
//    suspend fun refreshToken(
//        @Body refreshRequest: RefreshRequest
//    ): Response<ResponseApi<RefreshToken>>

    @POST("registration")
    suspend fun registerUser(
        @Body registrationRequest: RegistrationRequest
    ): Response<ApiResponseWrapper<Nullable>>

    @POST("login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): Response<ApiResponseWrapper<LoginResponse>>

    @GET("profile")
    suspend fun getProfile(): Response<ApiResponseWrapper<ProfileResponse>>

    @PUT("profile/update")
    suspend fun updateProfile(
        @Body profileRequest: ProfileRequest
    ): Response<ApiResponseWrapper<ProfileResponse>>

    @Multipart
    @PUT("profile/image")
    suspend fun updateProfileImage(
        @Part file: MultipartBody.Part
    ): Response<ApiResponseWrapper<ProfileResponse>>

    @POST("refreshToken")
    suspend fun refreshToken(
        @Body refreshRequest: String?
    ): Response<ApiResponseWrapper<RefreshTokenResponse>>
}




