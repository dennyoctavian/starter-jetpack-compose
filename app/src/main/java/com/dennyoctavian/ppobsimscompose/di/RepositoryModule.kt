package com.dennyoctavian.ppobsimscompose.di

import com.dennyoctavian.ppobsimscompose.data.repository.InformationRepositoryImpl
import com.dennyoctavian.ppobsimscompose.data.repository.MembershipRepositoryImpl
import com.dennyoctavian.ppobsimscompose.data.repository.TransactionRepositoryImpl
import com.dennyoctavian.ppobsimscompose.domain.repository.InformationRepository
import com.dennyoctavian.ppobsimscompose.domain.repository.MembershipRepository
import com.dennyoctavian.ppobsimscompose.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMembershipRepository(
        membershipRepositoryImpl: MembershipRepositoryImpl
    ): MembershipRepository

    @Binds
    abstract fun bindInformationRepository(
        informationRepositoryImpl: InformationRepositoryImpl
    ): InformationRepository

    @Binds
    abstract fun bindTransactionRepository(
        transactionRepositoryImpl: TransactionRepositoryImpl
    ): TransactionRepository
}