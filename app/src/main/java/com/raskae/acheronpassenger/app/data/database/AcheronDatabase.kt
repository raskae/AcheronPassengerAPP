package com.raskae.acheronpassenger.app.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.raskae.acheronpassenger.app.domain.model.AccountDTO
import repository.local.dao.AccountDao

/**
 * Created by Raskae on 08/03/2018.
 */
@Database(entities = arrayOf(AccountDTO::class), version = 1)
abstract class AcheronDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}