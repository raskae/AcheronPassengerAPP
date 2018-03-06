package com.raskae.acheronpassenger.core.model

/**
 * Created by Raskae on 18/01/2018.
 */
data class AccountDTO(
        val _id: String,
        val alias: String,
        val email: String,
        val login: String,
        val owner: String,
        val password: String,
        val status: String,
        val url: String,
        val owner_account: String,
        val tags: Collection<String>,
        val additional_data: List<AdditionalDataDTO>,
        val coowners: Collection<String>
) {

}