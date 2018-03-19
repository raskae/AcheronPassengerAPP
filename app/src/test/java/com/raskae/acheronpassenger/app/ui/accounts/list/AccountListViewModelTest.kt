package com.raskae.acheronpassenger.app.ui.accounts.list

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.util.SchedulerProvider
import io.reactivex.Flowable
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
class AccountListViewModelTest {

    @Mock
    var mockAccount: AccountResource = Mockito.mock(AccountResource::class.java)

    @Mock
    private lateinit var mockAccountRepository: AccountRepository
//    private lateinit var mockDatasourceRemote: RemoteAccountDatasource

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var accountListViewModel: AccountListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        accountListViewModel = AccountListViewModel(mockAccountRepository, schedulerProvider)
    }

    @Test
    fun getAllAccounts() {
        Mockito.`when`(mockAccountRepository.getAllAccounts()).thenReturn(Flowable.just(arrayListOf(mockAccount)))

        val testObserver = TestObserver<AccountResource>()

//        accountListViewModel.getAllAccounts().subscribe()
//                .subscribe(testObserver)

        testObserver.assertNoErrors()
        //testObserver.assertComplete() { account -> account.username}
    }

}