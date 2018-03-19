package com.raskae.acheronpassenger.app.ui.accounts.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.domain.resources.AccountResource
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource
import com.raskae.acheronpassenger.app.ui.accounts.list.adapter.AccountListRecyclerAdapter
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AccountListFragment : Fragment() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    var disposable: Disposable? = null
    var accountList = ArrayList<AccountResource>()
    var accountSummaryList = ArrayList<AccountSummaryResource>()

    @Inject
    lateinit var accountListViewModel: AccountListViewModel

    var adapter: AccountListRecyclerAdapter? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById(R.id.rv_main_account_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        adapter = AccountListRecyclerAdapter(accountSummaryList)
        recyclerView.adapter = adapter

        getAllAccountsSummary()
    }

    fun getAllAccountsSummary() {

        compositeDisposable.add(accountListViewModel.getAllAccountsSummary()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            Log.d("Result", "AccountSummaryDTO List: ${result}")
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

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}// Required empty public constructor
