package repository.remote

import com.raskae.acheronpassenger.app.data.network.APIService
import com.raskae.acheronpassenger.app.domain.model.UserDTO
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by raskae on 1/19/18.
 */
@Singleton
class RemoteAccountDatasource @Inject constructor(private val apiService: APIService) {

    fun getAllUsers(): Flowable<List<UserDTO>> {
        return apiService.getAllUsers()
    }

    fun getAllAccounts(): Flowable<List<AccountResource>> {
        return apiService.getAllAccounts()
    }

    fun getAllAccountsSummary(): Flowable<List<AccountSummaryResource>> {
        return apiService.getAllAccountsSummary()
    }

    fun getAccountByAlias(alias: String): Single<AccountResource> {
        return apiService.getAccountByAlias(alias)
    }

    fun saveAccount(accountResource: AccountResource): Single<AccountResource> {
        return apiService.saveAccount(accountResource)
    }
}