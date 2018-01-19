package com.raskae.acheronpassenger.app.accounts.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import com.raskae.acheronpassenger.R

class AccountListActivity : AppCompatActivity() {

    var accountsRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)

        //accountsRecyclerView = findViewById(R.id.rv_main_account_list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
