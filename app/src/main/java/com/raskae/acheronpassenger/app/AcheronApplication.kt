package com.raskae.acheronpassenger.app

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import com.raskae.acheronpassenger.app.di.DaggerAppComponent
import com.raskae.acheronpassenger.core.database.AppDatabase
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by raskae on 1/18/18.
 */
class AcheronApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector:
            DispatchingAndroidInjector<Activity>

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        AcheronApplication.database =  Room.databaseBuilder(this, AppDatabase::class.java, "acheron-domain-db").build()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}