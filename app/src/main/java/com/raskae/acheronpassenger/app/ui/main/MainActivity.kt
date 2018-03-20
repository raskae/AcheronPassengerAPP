package com.raskae.acheronpassenger.app.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.ui.accounts.crud.AccountDetailFragment
import com.raskae.acheronpassenger.app.ui.accounts.list.AccountListFragment
import com.raskae.acheronpassenger.app.util.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : DaggerAppCompatActivity() {

    //TODO Ptenni ver si me conviene injectar el fragment like this
//    @Inject
//    lateinit var accountListFragmentProvider: AccountListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
//        toolbar.logo = getDrawable(R.drawable)

        replaceFragment(AccountListFragment(), R.id.main_container)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.action_new -> {
                replaceFragment(AccountDetailFragment(), R.id.main_container)
            }
            R.id.action_refresh -> {
                replaceFragment(AccountListFragment(), R.id.main_container)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
