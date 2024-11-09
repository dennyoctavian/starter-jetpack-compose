package com.dennyoctavian.ppobsimscompose.domain.repository

import androidx.annotation.Nullable
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.LoginRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.ProfileRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.RegistrationRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.LoginResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ProfileResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.RefreshTokenResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import okhttp3.MultipartBody


interface MembershipRepository {
//    suspend fun getUserData(): APIResponse<ProfileResponse>
//    suspend fun refreshToken(): RefreshToken?

    suspend fun register(registrationRequest: RegistrationRequest): NetworkResult<Nullable>
    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse>
    suspend fun getProfile(): NetworkResult<ProfileResponse>
    suspend fun updateProfile(profileRequest: ProfileRequest): NetworkResult<ProfileResponse>
    suspend fun updateProfilePicture(
        file: MultipartBody.Part
    ): NetworkResult<ProfileResponse>

    suspend fun refreshToken(): NetworkResult<RefreshTokenResponse>
}