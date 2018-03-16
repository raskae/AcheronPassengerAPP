package com.raskae.acheronpassenger.app.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Raskae on 18/01/2018.
 */
@Entity(tableName = "accounts")
data class AccountDTO(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val alias: String,
        val email: String,
        val login: String,
        val owner: String,
        val password: String,
        val status: String,
        val url: String,
        val category: String,
        val owner_account: String
//        ,
//        val tags: Collection<String>,
//        val additional_data: List<AdditionalDataDTO>,
//        val coowners: Collection<String>
) {
}