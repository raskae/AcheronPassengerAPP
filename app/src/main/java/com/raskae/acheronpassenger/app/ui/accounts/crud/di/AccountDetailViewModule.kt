package com.raskae.acheronpassenger.app.ui.accounts.crud.di

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import com.raskae.acheronpassenger.app.ui.accounts.crud.AccountDetailViewModel
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
class AccountDetailViewModule {

    @Provides
    fun provideViewModel(repository: AccountRepository, schedulerProvider: SchedulerProvider) = AccountDetailViewModel(repository, schedulerProvider)
}