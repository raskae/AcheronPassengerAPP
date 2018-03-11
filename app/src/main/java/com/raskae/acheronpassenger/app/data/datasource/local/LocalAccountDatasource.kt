package repository.local

import com.raskae.acheronpassenger.app.domain.model.AccountDTO
import io.reactivex.Flowable
import repository.local.dao.AccountDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Raskae on 08/03/2018.
 */
@Singleton
class LocalAccountDatasource @Inject constructor(private val accountDao: AccountDao) {

    fun getAllAccounts(): Flowable<List<AccountDTO>?>? {

        return Flowable.just(accountDao.getAllAccounts())
    }

    fun getAllAccount(): List<AccountDTO>? {
        return accountDao.getAllAccounts()
    }
}
