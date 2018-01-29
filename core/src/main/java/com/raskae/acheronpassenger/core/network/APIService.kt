package com.raskae.acheronpassenger.core.network

import com.raskae.acheronpassenger.core.model.AccountDTO
import com.raskae.acheronpassenger.core.model.UserDTO
import com.raskae.acheronpassenger.core.network.constants.ServiceContants
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by raskae on 1/19/18.
 */
interface APIService {

    @GET("user")
    fun getAllUsers(): Observable<List<UserDTO>>

    @GET("accounts")
    fun getAllAccounts(): Observable<List<AccountDTO>>

    @GET("accounts")
    fun getAccountByAlias(@Query("alias") alias: String): Observable<AccountDTO>


    companion object ServiceGenerator {

        fun create(): APIService {

            //level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//            val client = OkHttpClient().newBuilder()
//                    .addInterceptor(HttpLoggingInterceptor().apply {
//                        level=HttpLoggingInterceptor.Level.BODY
//                    })
//                    .build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ServiceContants.BASE_URL)
//                    .client(client)
                    .build()

            return retrofit.create(APIService::class.java)
        }
    }

}