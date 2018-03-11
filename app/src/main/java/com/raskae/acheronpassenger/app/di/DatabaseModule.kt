package com.raskae.acheronpassenger.app.di

import android.app.Application
import android.arch.persistence.room.Room
import com.raskae.acheronpassenger.app.data.database.AcheronDatabase
import dagger.Module
import dagger.Provides
import repository.local.LocalAccountDatasource
import repository.local.dao.AccountDao
import javax.inject.Singleton


/**
 * Created by raskae on 3/11/18.
 */
@Module(includes = arrayOf(AppModule::class))
class DatabaseModule {

    private val DATABASE_NAME = "acheron-domain-db"

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AcheronDatabase {
        return Room.databaseBuilder(application,
                AcheronDatabase::class.java, DATABASE_NAME)
                .build()
    }

    @Singleton
    @Provides
    fun provideAccountDao(db: AcheronDatabase): AccountDao {
        return db.accountDao()
    }

    @Singleton
    @Provides
    fun provideLocalAccountDatasource(dao: AccountDao): LocalAccountDatasource {
        return LocalAccountDatasource(dao)
    }

}