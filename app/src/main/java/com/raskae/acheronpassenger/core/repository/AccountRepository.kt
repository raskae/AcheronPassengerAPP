package com.raskae.acheronpassenger.core.repository

import com.raskae.acheronpassenger.core.model.AccountDTO
import com.raskae.acheronpassenger.core.model.UserDTO
import com.raskae.acheronpassenger.core.network.APIService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by raskae on 1/19/18.
 */
@Singleton
class AccountRepository @Inject constructor(private val apiService: APIService) {

    fun getAllUsers(): Observable<List<UserDTO>> {
        return apiService.getAllUsers()
    }

    fun getAllAccounts(): Observable<List<AccountDTO>> {
        return apiService.getAllAccounts()
    }

    fun getAccountByAlias(alias: String): Observable<AccountDTO> {
        return apiService.getAccountByAlias(alias)
    }

//    object AccountRepository {
//        fun provideAccountRepository(): com.raskae.acheronpassenger.core.Repository.AccountRepository {
//            return AccountRepository()
//        }
//    }

}