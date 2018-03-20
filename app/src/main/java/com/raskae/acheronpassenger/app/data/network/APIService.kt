package com.raskae.acheronpassenger.app.data.network

import com.raskae.acheronpassenger.app.domain.model.UserDTO
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by raskae on 1/19/18.
 */
interface APIService {

    @GET("user")
    fun getAllUsers(): Flowable<List<UserDTO>>

    @GET("accounts")
    fun getAllAccounts(): Flowable<List<AccountResource>>

    @GET("accounts/summary")
    fun getAllAccountsSummary(): Flowable<List<AccountSummaryResource>>

    @GET("accounts")
    fun getAccountByAlias(@Query("alias") alias: String): Single<AccountResource>

    @POST("accounts")
    fun saveAccount(@Body accountResource: AccountResource): Single<AccountResource>

}