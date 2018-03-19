package com.raskae.acheronpassenger.app.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.ui.accounts.crud.AccountDetailFragment
import com.raskae.acheronpassenger.app.util.addFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
//        , HasSupportFragmentInjector
{

//    @Inject
//    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        return fragmentDispatchingAndroidInjector
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
//        toolbar.logo = getDrawable(R.drawable)

//        val accountListFragment: AccountListFragment = AccountListFragment()
//        addFragment(accountListFragment, R.id.main_container)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.action_new -> {
                //startActivity(Intent(this, AccountDetailActivity::class.java))
                val accountDetailFragment: AccountDetailFragment = AccountDetailFragment()
                addFragment(accountDetailFragment, R.id.main_container)
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
