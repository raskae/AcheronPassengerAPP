package com.raskae.acheronpassenger.app.ui.accounts.list

import com.raskae.acheronpassenger.app.util.SchedulerProvider
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import repository.remote.RemoteAccountDatasource
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Raskae on 06/03/2018.
 */
class AccountListActivityViewModelTest {

    @Mock
    var mockAccount: AccountResource = Mockito.mock(AccountResource::class.java)

    @Mock
    private lateinit var mockDatasourceRemote: RemoteAccountDatasource

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var accountListActivityViewModel: AccountListActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        accountListActivityViewModel = AccountListActivityViewModel(mockDatasourceRemote, schedulerProvider)
    }

    @Test
    fun getAllAccounts() {
        Mockito.`when`(mockDatasourceRemote.getAllAccounts()).thenReturn(Observable.just(arrayListOf(mockAccount)))

        val testObserver = TestObserver<AccountResource>()

//        accountListActivityViewModel.getAllAccounts().subscribe()
//                .subscribe(testObserver)

        testObserver.assertNoErrors()
        //testObserver.assertComplete() { account -> account.username}
    }

}