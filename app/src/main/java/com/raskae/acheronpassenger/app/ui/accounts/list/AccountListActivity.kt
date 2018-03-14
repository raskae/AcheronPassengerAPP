package com.raskae.acheronpassenger.app.ui.accounts.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import com.raskae.acheronpassenger.app.ui.accounts.list.adapter.AccountListRecyclerAdapter
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AccountListActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    var disposable: Disposable? = null
    var accountList = ArrayList<AccountResource>()
    var accountSummaryList = ArrayList<AccountSummaryResource>()

    @Inject
    lateinit var accountListActivityViewModel: AccountListActivityViewModel

    var adapter: AccountListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        val recyclerView = findViewById(R.id.rv_main_account_list) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

//        getAllAccounts()
        getAllAccountsSummary()

        //creating our adapter
        adapter = AccountListRecyclerAdapter(accountSummaryList)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    fun getAllAccountsSummary() {

        compositeDisposable.add(accountListActivityViewModel.getAllAccountsSummary()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            Log.d("Result", "AccountSummary List: ${result}")
                            accountSummaryList = result as ArrayList<AccountSummaryResource>
                            adapter?.accountList = accountSummaryList
                            adapter?.notifyDataSetChanged()
                        },
                        { error ->
                            Log.d("ErrorResult", error.toString())
                            error.printStackTrace()
                        }
                )
        )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
