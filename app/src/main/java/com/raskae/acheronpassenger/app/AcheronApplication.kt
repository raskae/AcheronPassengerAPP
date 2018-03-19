package com.raskae.acheronpassenger.app

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.raskae.acheronpassenger.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject


/**
 * Created by raskae on 1/18/18.
 */
class AcheronApplication : Application(), HasActivityInjector
//        , HasSupportFragmentInjector
{
//    @Inject
//    lateinit var fragmentDispatchingAndroidInjector: AndroidInjector<Fragment>
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>



    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        Fabric.with(this, Crashlytics())

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}