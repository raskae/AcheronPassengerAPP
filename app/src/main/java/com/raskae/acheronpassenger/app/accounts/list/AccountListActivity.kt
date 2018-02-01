package com.raskae.acheronpassenger.app.accounts.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.accounts.list.adapter.AccountListRecyclerAdapter
import com.raskae.acheronpassenger.core.model.AccountDTO
import com.raskae.acheronpassenger.core.model.UserDTO
import com.raskae.acheronpassenger.core.network.APIService
import com.raskae.acheronpassenger.core.repository.AccountRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AccountListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var disposable: Disposable? = null


    val apiService by lazy { APIService.create() }

    var accountsRecyclerView: RecyclerView? = null

    var accountList = ArrayList<AccountDTO>()

    //val repository = AccountRepository(apiService)
    var repository: AccountRepository? = null

    var adapter: AccountListRecyclerAdapter? = null

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        //accountsRecyclerView = findViewById(R.id.rv_main_account_list)

        val recyclerView = findViewById(R.id.rv_main_account_list) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        repository = AccountRepository(apiService)

        //getAllUsers()

        getAllAccounts()

        //getAccountByAlias("testAccount")

        //adding some dummy data to the list
//        accountList.add(AccountDTO("gmail raskae", "raskae@gmail.com", "www.gmail.com"))
//        accountList.add(AccountDTO("gmail tenni.pier", "tenni.pier@gmail.com", "www.gmail.com"))


        //creating our adapter
        adapter = AccountListRecyclerAdapter(accountList)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }


    fun getAllAccounts() {

        disposable =
                repository?.getAllAccounts()
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribeOn(Schedulers.io())
                        ?.subscribe(
                                { result ->
                                    Log.d("Result", "Account List: ${result}")
                                    accountList = result as ArrayList<AccountDTO>
                                    adapter?.accountList = accountList
                                    adapter?.notifyDataSetChanged()
                                },
                                { error ->
                                    Log.d("ErrorResult", error.toString())
                                    error.printStackTrace()
                                })
    }

    fun getAccountByAlias(alias: String) {

        disposable =
                repository?.getAccountByAlias(alias)
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribeOn(Schedulers.io())
                        ?.subscribe(
                                { result ->
                                    Log.d("Result", "Account Intel: ${result}")
                                    accountList.add(result)
                                },
                                { error ->
                                    Log.d("ErrorResult", error.toString())
                                    error.printStackTrace()
                                })
    }


    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }


    fun getAllUsers() {

        disposable =
                repository?.getAllUsers()
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribeOn(Schedulers.io())
                        ?.subscribe(
                                { result ->
                                    Log.d("Result", "User List: ${result}")
                                    var accountList = result as ArrayList<UserDTO>
                                },
                                { error ->
                                    Log.d("ErrorResult", error.toString())
                                    error.printStackTrace()
                                })
    }
}
