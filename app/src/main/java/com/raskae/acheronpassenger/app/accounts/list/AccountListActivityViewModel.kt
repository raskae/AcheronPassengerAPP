package com.raskae.acheronpassenger.app.accounts.list

import com.raskae.acheronpassenger.app.util.SchedulerProvider
import com.raskae.acheronpassenger.core.model.AccountResource
import com.raskae.acheronpassenger.core.repository.remote.AccountRepository
import io.reactivex.Observable

/**
 * Created by Raskae on 02/03/2018.
 */
class AccountListActivityViewModel(private val repository: AccountRepository, private val schedulerProvider: SchedulerProvider) {

//    fun getAllAccounts(): Observable<List<AccountResource>> = repository.getAllAccounts()
//            .compose(schedulerProvider.getSchedulersForObservable())

    fun getAllAccounts(): Observable<List<AccountResource>> = repository.getAllAccounts()
            .compose(schedulerProvider.getSchedulersForObservable())
}
