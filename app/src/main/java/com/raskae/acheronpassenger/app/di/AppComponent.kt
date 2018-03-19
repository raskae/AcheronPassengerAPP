package com.raskae.acheronpassenger.app.di

import android.app.Application
import com.raskae.acheronpassenger.app.AcheronApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Raskae on 02/03/2018.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        DatabaseModule::class,
        ActivityBuilder::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(acheronApplication: AcheronApplication)

    fun inject(accountListFragment: ActivityBuilder_BindAccountListFragment)
}