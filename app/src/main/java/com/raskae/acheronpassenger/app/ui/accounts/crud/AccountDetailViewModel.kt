package com.raskae.acheronpassenger.app.ui.accounts.crud

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Raskae on 02/03/2018.
 */
class AccountDetailViewModel @Inject constructor(private val repository: AccountRepository, private val schedulerProvider: SchedulerProvider) {

//    fun getAccountDetailByID(): Single<AccountResource> = repository.getAccountByAlias()
//            .compose(schedulerProvider.getSchedulersForFlowable())

    fun getAccountDetailByAlias(alias: String): Single<AccountResource> = repository.getAccountByAlias(alias)
            .compose(schedulerProvider.getSchedulersForSingle())

    fun saveAccount(accountResource: AccountResource): Single<AccountResource> = repository.saveAccount(accountResource)
            .compose(schedulerProvider.getSchedulersForSingle())

}
