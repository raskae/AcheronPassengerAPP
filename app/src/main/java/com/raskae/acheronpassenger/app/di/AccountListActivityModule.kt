package com.raskae.acheronpassenger.app.di

import com.raskae.acheronpassenger.app.ui.accounts.list.AccountListActivityViewModel
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
class AccountListActivityModule {

    @Provides
    fun provideViewModel(repository: AccountRepository, schedulerProvider: SchedulerProvider) = AccountListActivityViewModel(repository, schedulerProvider)
}