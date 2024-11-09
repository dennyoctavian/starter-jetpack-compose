package com.dennyoctavian.ppobsimscompose.di

import com.dennyoctavian.ppobsimscompose.data.local.preferences.SharedPreferencesTokenProvider
import com.dennyoctavian.ppobsimscompose.data.remote.InformationService
import com.dennyoctavian.ppobsimscompose.data.remote.MembershipService
import com.dennyoctavian.ppobsimscompose.data.remote.TransactionService
import com.dennyoctavian.ppobsimscompose.data.remote.interceptor.AuthInterceptor
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import com.dennyoctavian.ppobsimscompose.utils.Constant
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
    ): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideInformationService(retrofit: Retrofit): InformationService {
        return retrofit.create(InformationService::class.java)
    }

    @Provides
    @Singleton
    fun provideMembershipService(retrofit: Retrofit): MembershipService {
        return retrofit.create(MembershipService::class.java)
    }

    @Provides
    @Singleton
    fun provideTransactionService(retrofit: Retrofit): TransactionService {
        return retrofit.create(TransactionService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(
        sharedPreferencesTokenProvider: SharedPreferencesTokenProvider,
        membershipRepository: Lazy<MembershipRepository>
    ): AuthInterceptor {
        return AuthInterceptor(
            sharedPreferencesTokenProvider, membershipRepository
        )

    }
}
