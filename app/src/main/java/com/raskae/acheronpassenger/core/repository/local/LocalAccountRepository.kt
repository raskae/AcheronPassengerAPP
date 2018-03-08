package com.raskae.acheronpassenger.core.repository.local

import com.raskae.acheronpassenger.core.database.AppDatabase
import com.raskae.acheronpassenger.core.model.AccountDTO
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Raskae on 08/03/2018.
 */
@Singleton
class LocalAccountRepository @Inject constructor(private val appDatabase: AppDatabase) {

    fun getAllAccounts(): Flowable<List<AccountDTO>?>? {

        return Flowable.just(appDatabase?.accountDao()?.getAllAccounts())
    }

    fun getAllAccount(): List<AccountDTO>? {
        return appDatabase?.accountDao()?.getAllAccounts()
    }
}
