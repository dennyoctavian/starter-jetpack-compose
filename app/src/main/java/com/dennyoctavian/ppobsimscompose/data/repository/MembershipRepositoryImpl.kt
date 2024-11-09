package com.dennyoctavian.ppobsimscompose.data.repository

import androidx.annotation.Nullable
import com.dennyoctavian.ppobsimscompose.data.remote.MembershipService
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.LoginRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.ProfileRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.request.RegistrationRequest
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.LoginResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.ProfileResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.RefreshTokenResponse
import com.dennyoctavian.ppobsimscompose.data.remote.model.response.base.NetworkResult
import com.dennyoctavian.ppobsimscompose.domain.local.preferences.TokenProvider
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import com.dennyoctavian.ppobsimscompose.utils.handleException
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MembershipRepositoryImpl @Inject constructor(
    private val membershipService: MembershipService,
    private val tokenProvider: TokenProvider
) : MembershipRepository {

    override suspend fun refreshToken(): NetworkResult<RefreshTokenResponse> {
        return try {
            val response = membershipService.refreshToken(
                tokenProvider.getRefreshToken()
            )
            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }
        } catch (e: Exception) {
            handleException(e)
        }
    }


    override suspend fun register(registrationRequest: RegistrationRequest): NetworkResult<Nullable> {
        return try {
            val response = membershipService.registerUser(registrationRequest)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(null)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> {
        return try {
            val response = membershipService.loginUser(loginRequest)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(response.body()?.data!!)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun getProfile(): NetworkResult<ProfileResponse> {
        return try {
            val response = membershipService.getProfile()

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(response.body()?.data!!)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun updateProfile(profileRequest: ProfileRequest): NetworkResult<ProfileResponse> {
        return try {
            val response = membershipService.updateProfile(profileRequest)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(response.body()?.data!!)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun updateProfilePicture(file: MultipartBody.Part): NetworkResult<ProfileResponse> {
        return try {
            val response = membershipService.updateProfileImage(file)

            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.status == 0) {
                    return NetworkResult.Success(response.body()?.data!!)
                } else {
                    return NetworkResult.Error(response.body()!!.status, response.body()!!.message)
                }
            } else {
                NetworkResult.Error(response.body()!!.status, response.body()!!.message)
            }

        } catch (e: Exception) {
            handleException(e)
        }
    }


}