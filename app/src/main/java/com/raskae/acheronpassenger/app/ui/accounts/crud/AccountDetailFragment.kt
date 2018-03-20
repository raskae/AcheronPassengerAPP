package com.raskae.acheronpassenger.app.ui.accounts.crud

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raskae.acheronpassenger.R
import javax.inject.Inject

class AccountDetailFragment : Fragment(), View.OnClickListener, View.OnLongClickListener {

    override fun onLongClick(v: View?): Boolean {
        println("onLongClick")
        return true
    }


    @Inject
    lateinit var accountDetailViewModel: AccountDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_detail, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_save_account -> {
                //accountDetailViewModel.saveAccount(AccountResource("",))
                println("creando account")
            }
        }
    }

}
