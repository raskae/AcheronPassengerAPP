package com.raskae.acheronpassenger.app.di

import com.raskae.acheronpassenger.app.data.repository.AccountRepository
import dagger.Module
import dagger.Provides
import repository.local.LocalAccountDatasource
import repository.remote.RemoteAccountDatasource

/**
 * Created by raskae on 3/11/18.
 */
@Module
class RepositoryModule {

    @Provides
    fun provideAccountRepository(
            localAccountDatasource: LocalAccountDatasource,
            remoteAccountDatasource: RemoteAccountDatasource): AccountRepository {
        return AccountRepository(
                localAccountDatasource,
                remoteAccountDatasource)
    }
}