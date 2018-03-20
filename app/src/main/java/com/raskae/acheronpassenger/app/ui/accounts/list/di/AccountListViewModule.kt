package com.raskae.acheronpassenger.app.ui.accounts.list.di

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import com.raskae.acheronpassenger.app.ui.accounts.list.AccountListViewModel
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
class AccountListViewModule {

    @Provides
    fun provideViewModel(repository: AccountRepository, schedulerProvider: SchedulerProvider) = AccountListViewModel(repository, schedulerProvider)
}