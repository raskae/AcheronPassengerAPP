package com.raskae.acheronpassenger.app.accounts.list

import com.raskae.acheronpassenger.app.util.SchedulerProvider
import com.raskae.acheronpassenger.core.model.AccountDTO
import com.raskae.acheronpassenger.core.repository.AccountRepository
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
    var mockAccount: AccountDTO = Mockito.mock(AccountDTO::class.java)

    @Mock
    private lateinit var mockRepository: AccountRepository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var accountListActivityViewModel: AccountListActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        accountListActivityViewModel = AccountListActivityViewModel(mockRepository, schedulerProvider)
    }

    @Test
    fun getAllAccounts() {
        Mockito.`when`(mockRepository.getAllAccounts()).thenReturn(Observable.just(arrayListOf(mockAccount)))

        val testObserver = TestObserver<AccountDTO>()

//        accountListActivityViewModel.getAllAccounts().subscribe()
//                .subscribe(testObserver)

        testObserver.assertNoErrors()
        //testObserver.assertComplete() { account -> account.username}
    }

}