package com.raskae.acheronpassenger.app.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            val intent = Intent(this, LoginActivity::class.java)
            //intent.putExtra(INTENT_USER_ID, user.id)

            startActivity(intent)

        }, 2000)

    }
}
