package com.dennyoctavian.ppobsimscompose.di

import com.dennyoctavian.ppobsimscompose.data.local.preferences.SharedPreferencesTokenProvider
import com.dennyoctavian.ppobsimscompose.domain.local.preferences.TokenProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Makes this module available throughout the app
abstract class TokenModule {

    @Binds
    @Singleton
    abstract fun bindTokenProvider(
        sharedPreferencesTokenProvider: SharedPreferencesTokenProvider
    ): TokenProvider
}