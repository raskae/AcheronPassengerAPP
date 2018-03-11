package com.raskae.acheronpassenger.app.ui.accounts.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.domain.resources.AccountResource

/**
 * Created by Raskae on 18/01/2018.
 */
class AccountListRecyclerAdapter(var accountList: ArrayList<AccountResource>
//                                 , private val listener: Listener
) : RecyclerView.Adapter<AccountListRecyclerAdapter.AccountListViewHolder>() {

    interface Listener {

        fun onItemClick(accountDTO: AccountResource)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountListViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.account_list_item, parent, false)
        return AccountListViewHolder(v
                //,listener
        )
    }

    override fun onBindViewHolder(holder: AccountListViewHolder?, position: Int) {
        holder?.bindItems(accountList[position])
    }


    override fun getItemCount(): Int {
        return accountList.size
    }



    class AccountListViewHolder(itemView: View
            //, listener: Listener
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(accountModel: AccountResource) {
            val textViewAlias = itemView.findViewById(R.id.tv_account_alias) as TextView
            val textViewLogin = itemView.findViewById(R.id.tv_account_login) as TextView
            val textViewUrl = itemView.findViewById(R.id.tv_account_url) as TextView
            textViewAlias.text = accountModel.alias
            textViewLogin.text = accountModel.login
            textViewUrl.text = accountModel.url
        }

    }
}

