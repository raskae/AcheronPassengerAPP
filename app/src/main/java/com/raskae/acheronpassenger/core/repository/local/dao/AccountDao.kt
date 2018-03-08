package com.raskae.acheronpassenger.core.repository.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.raskae.acheronpassenger.core.model.AccountDTO


/**
 * Created by Raskae on 08/03/2018.
 */
@Dao
interface AccountDao {

    @Query("SELECT * FROM account")
    fun getAllAccounts(): List<AccountDTO>

    @Query("SELECT * FROM account WHERE alias LIKE :alias LIMIT 1")
    fun findByAlias(alias: String): AccountDTO

    @Insert
    fun insert(account: AccountDTO)

    @Delete
    fun delete(account: AccountDTO)
}