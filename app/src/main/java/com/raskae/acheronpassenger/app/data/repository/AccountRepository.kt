package com.raskae.acheronpassenger.app.data.repository

import com.raskae.acheronpassenger.app.domain.model.AccountDTO
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import io.reactivex.Flowable
import io.reactivex.Single
import repository.local.LocalAccountDatasource
import repository.remote.RemoteAccountDatasource
import javax.inject.Inject

class AccountRepository @Inject constructor(
        private val localDatasource: LocalAccountDatasource,
        private val remoteDatasource: RemoteAccountDatasource) {


    //override fun getAllAccountsSummary(): Flowable<AccountDTO>? {
    fun getAllAccountsSummary(): Flowable<List<AccountSummaryResource>> {

        println("WAAAAAAAAAAAAAAAAAAAAAAAAASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")

        return remoteDatasource.getAllAccountsSummary()
        //return localDatasource.getAllAccount()
//        return remoteDatasource.getAllAccounts().map { t: List<AccountResource> ->  {
//            AccountDTO()
//        }}
    }

    fun getAllAccounts(): Flowable<List<AccountResource>> {
        return remoteDatasource.getAllAccounts()
    }

    fun getAccountByAlias(alias: String): Single<AccountResource> {
        return remoteDatasource.getAccountByAlias(alias)
    }

    fun getAccountByParameter(parameter: String): Flowable<AccountDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun saveAccount(accountResource: AccountResource): Single<AccountResource> {
        return remoteDatasource.saveAccount(accountResource)
    }


}