package com.raskae.acheronpassenger.app.domain.model

/**
 * Created by Raskae on 18/01/2018.
 */
data class AccountSummaryDTO(
        val _id: String,
        val alias: String,
        val login: String,
        val url: String,
        val category: String,
        val password: String
)