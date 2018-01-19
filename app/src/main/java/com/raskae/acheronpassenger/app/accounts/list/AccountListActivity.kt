package com.raskae.acheronpassenger.app.accounts.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.LinearLayout
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.accounts.list.adapter.AccountListRecyclerAdapter
import com.raskae.acheronpassenger.core.model.AccountDTO

class AccountListActivity : AppCompatActivity() {

    var accountsRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        //accountsRecyclerView = findViewById(R.id.rv_main_account_list)

        val recyclerView = findViewById(R.id.rv_main_account_list) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val accountList = ArrayList<AccountDTO>()

        //adding some dummy data to the list
        accountList.add(AccountDTO("gmail raskae", "raskae@gmail.com", "www.gmail.com"))
        accountList.add(AccountDTO("gmail tenni.pier", "tenni.pier@gmail.com", "www.gmail.com"))


        //creating our adapter
        val adapter = AccountListRecyclerAdapter(accountList)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
