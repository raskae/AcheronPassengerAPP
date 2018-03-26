package com.raskae.acheronpassenger.app.ui.accounts.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.domain.resources.AccountSummaryResource

/**
 * Created by Raskae on 18/01/2018.
 */
class AccountListRecyclerAdapter(var accountList: ArrayList<AccountSummaryResource>
//                                 , private val listener: Listener
) : RecyclerView.Adapter<AccountListRecyclerAdapter.AccountListViewHolder>() {

//    interface Listener {
//
//        fun onItemClick(accountDTO: AccountResource)
//    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountListViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context).inflate(R.layout.account_list_item, parent, false)
        return AccountListViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: AccountListViewHolder?, position: Int) {
        holder?.bindItems(accountList[position])
    }


    override fun getItemCount(): Int {
        return accountList.size
    }


    class AccountListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
            , View.OnClickListener, View.OnLongClickListener {

        var textHiddenPassword: String = ""
        val textViewAlias = itemView.findViewById(R.id.tv_account_alias) as TextView
        val textViewLogin = itemView.findViewById(R.id.tv_account_login) as TextView
        val textViewUrl = itemView.findViewById(R.id.tv_account_url) as TextView
        val imgViewPassword = itemView.findViewById(R.id.img_view_password) as ImageView
        val imgEditDetail = itemView.findViewById(R.id.img_edit_account) as ImageView

        init {
            imgEditDetail.setOnClickListener(this)
            imgViewPassword.setOnLongClickListener(this)
        }

        fun bindItems(accountModel: AccountSummaryResource) {

            textViewAlias.text = accountModel.alias
            textViewLogin.text = accountModel.login
            textViewUrl.text = accountModel.url
            textHiddenPassword = accountModel.password
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.img_edit_account -> {
                    println("view details")
                    val context = itemView.context


//                    val showPhotoIntent = Intent(context, PhotoActivity::class.java)
//                    showPhotoIntent.putExtra(PHOTO_KEY, photo)
//                    context.startActivity(showPhotoIntent)
                }
            }
        }

        override fun onLongClick(v: View?): Boolean {
            when (v?.id) {
                R.id.img_view_password -> {
                    val context = itemView.context
                    Toast.makeText(context, textHiddenPassword, Toast.LENGTH_SHORT).show()
                    println(textHiddenPassword)
                }
            }

            return true
        }
    }
}

