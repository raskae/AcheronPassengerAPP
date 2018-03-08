package com.raskae.acheronpassenger.core.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.raskae.acheronpassenger.core.model.AccountResource
import com.raskae.acheronpassenger.core.repository.local.dao.AccountDao

/**
 * Created by Raskae on 08/03/2018.
 */
@Database(entities = arrayOf(AccountResource::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}