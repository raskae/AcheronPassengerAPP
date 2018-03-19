package com.raskae.acheronpassenger.app.ui.accounts.list

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Raskae on 02/03/2018.
 */
class AccountListViewModel @Inject constructor(private val repository: AccountRepository, private val schedulerProvider: SchedulerProvider) {

//    fun getAllAccounts(): Observable<List<AccountResource>> = datasourceRemote.getAllAccounts()
//            .compose(schedulerProvider.getSchedulersForObservable())

    fun getAllAccounts(): Flowable<List<AccountResource>> = repository.getAllAccounts()
            .compose(schedulerProvider.getSchedulersForFlowable())

    fun getAllAccountsSummary(): Flowable<List<AccountSummaryResource>> = repository.getAllAccountsSummary()
            .compose(schedulerProvider.getSchedulersForFlowable())
    
}
