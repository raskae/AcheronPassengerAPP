package com.raskae.acheronpassenger.app.di

import com.raskae.acheronpassenger.app.ui.accounts.list.AccountListFragment
import com.raskae.acheronpassenger.app.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Raskae on 02/03/2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(AccountListViewModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(AccountListViewModule::class))
    abstract fun bindAccountListFragment(): AccountListFragment
}