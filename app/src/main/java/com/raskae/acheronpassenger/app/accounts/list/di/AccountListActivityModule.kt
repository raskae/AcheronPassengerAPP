package com.raskae.acheronpassenger.app.accounts.list.di

import com.raskae.acheronpassenger.app.accounts.list.AccountListActivityViewModel
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import com.raskae.acheronpassenger.core.network.APIService
import com.raskae.acheronpassenger.core.repository.remote.AccountRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
class AccountListActivityModule {

    @Provides
    fun provideRepository(apiService: APIService) = AccountRepository(apiService)

    @Provides
    fun provideViewModel(repository: AccountRepository, schedulerProvider: SchedulerProvider) = AccountListActivityViewModel(repository, schedulerProvider)
}