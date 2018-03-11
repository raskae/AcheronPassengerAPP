package repository.local.dao

import android.arch.persistence.room.*
import com.raskae.acheronpassenger.app.domain.model.AccountDTO


/**
 * Created by Raskae on 08/03/2018.
 */
@Dao
interface AccountDao {

    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): List<AccountDTO>

    @Query("SELECT * FROM accounts WHERE alias LIKE :alias LIMIT 1")
    fun findByAlias(alias: String): AccountDTO

    @Insert
    fun insert(account: AccountDTO)

    @Delete
    fun delete(account: AccountDTO)

    @Update
    fun update(account: AccountDTO): Int
}