package com.raskae.acheronpassenger.app.accounts.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.core.model.AccountDTO

/**
 * Created by Raskae on 18/01/2018.
 */
class AccountListRecyclerAdapter(val accountList: ArrayList<AccountDTO>) : RecyclerView.Adapter<AccountListRecyclerAdapter.AccountListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountListViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.account_list_item, parent, false)
        return AccountListViewHolder(v)
    }

    override fun onBindViewHolder(holder: AccountListViewHolder?, position: Int) {
        holder?.bindItems(accountList[position])
    }


    override fun getItemCount(): Int {
        return accountList.size
    }

    class AccountListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(accountModel: AccountDTO) {
            val textViewAlias = itemView.findViewById(R.id.tv_account_alias) as TextView
            val textViewLogin = itemView.findViewById(R.id.tv_account_login) as TextView
            val textViewUrl = itemView.findViewById(R.id.tv_account_url) as TextView
            textViewAlias.text = accountModel.alias
            textViewLogin.text = accountModel.login
            textViewUrl.text = accountModel.url
        }

    }
}

