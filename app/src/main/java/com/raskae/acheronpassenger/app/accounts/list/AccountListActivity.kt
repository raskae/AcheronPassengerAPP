package com.raskae.acheronpassenger.app.accounts.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.accounts.list.adapter.AccountListRecyclerAdapter
import com.raskae.acheronpassenger.core.model.AccountResource
import dagger.android.DaggerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AccountListActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    var disposable: Disposable? = null
    //val apiService by lazy { APIService.create() }
    //val repository = AccountRepository(apiService)

    var accountsRecyclerView: RecyclerView? = null
    var accountList = ArrayList<AccountResource>()

    @Inject
    lateinit var accountListActivityViewModel: AccountListActivityViewModel

    var adapter: AccountListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        //accountsRecyclerView = findViewById(R.id.rv_main_account_list)

        val recyclerView = findViewById(R.id.rv_main_account_list) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        getAllAccounts()

        //creating our adapter
        adapter = AccountListRecyclerAdapter(accountList)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }


    fun getAllAccounts() {

        compositeDisposable.add(accountListActivityViewModel.getAllAccounts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            Log.d("Result", "Account List: ${result}")
                            accountList = result as ArrayList<AccountResource>
                            adapter?.accountList = accountList
                            adapter?.notifyDataSetChanged()
                        },
                        { error ->
                            Log.d("ErrorResult", error.toString())
                            error.printStackTrace()
                        }
                )
        )

    }

//    fun getAccountByAlias(alias: String) {
//
//        disposable =
//                repository?.getAccountByAlias(alias)
//                        ?.observeOn(AndroidSchedulers.mainThread())
//                        ?.subscribeOn(Schedulers.io())
//                        ?.subscribe(
//                                { result ->
//                                    Log.d("Result", "Account Intel: ${result}")
//                                    accountList.add(result)
//                                },
//                                { error ->
//                                    Log.d("ErrorResult", error.toString())
//                                    error.printStackTrace()
//                                })
//    }


//    fun getAllUsers() {
//
//        disposable =
//                repository?.getAllUsers()
//                        ?.observeOn(AndroidSchedulers.mainThread())
//                        ?.subscribeOn(Schedulers.io())
//                        ?.subscribe(
//                                { result ->
//                                    Log.d("Result", "User List: ${result}")
//                                    var accountList = result as ArrayList<UserDTO>
//                                },
//                                { error ->
//                                    Log.d("ErrorResult", error.toString())
//                                    error.printStackTrace()
//                                })
//    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
