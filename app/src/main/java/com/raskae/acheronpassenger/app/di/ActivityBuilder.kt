package com.raskae.acheronpassenger.app.di

import com.raskae.acheronpassenger.app.accounts.list.AccountListActivity
import com.raskae.acheronpassenger.app.accounts.list.di.AccountListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(AccountListActivityModule::class))
    abstract fun bindAccountListActivity(): AccountListActivity
}