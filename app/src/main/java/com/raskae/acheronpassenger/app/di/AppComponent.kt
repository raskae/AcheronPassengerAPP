package com.raskae.acheronpassenger.app.di

/**
 * Created by Raskae on 02/03/2018.
 */
import android.app.Application
import com.raskae.acheronpassenger.app.AcheronApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AcheronApplication)
}