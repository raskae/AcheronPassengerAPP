package com.raskae.acheronpassenger.app.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.raskae.acheronpassenger.R
import com.raskae.acheronpassenger.app.accounts.list.AccountListActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "LoginActivity"
    private val RC_SIGN_IN = 9001

    var mGoogleSignInClient: GoogleSignInClient? = null

    var gotoMainActivityButton: Button? = null
    var signInButton: SignInButton? = null
    var signOutButton: Button? = null

    var tvUserName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        gotoMainActivityButton = findViewById(R.id.goto_mainactivity_button)
        signInButton = findViewById(R.id.sign_in_button)
        signOutButton = findViewById(R.id.sign_out_button)
        tvUserName = findViewById(R.id.tv_user_name)

        gotoMainActivityButton?.setOnClickListener(this)
        signInButton?.setOnClickListener(this)
        signOutButton?.setOnClickListener(this)

        // [START configure_signin]
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        // [END configure_signin]

        // [START build_client]
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        // [END build_client]
    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    // [START handleSignInResult]
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }

    }
    // [END handleSignInResult]

    // [START signIn]
    private fun signIn() {
        val signInIntent = mGoogleSignInClient?.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    // [END signIn]

    // [START signOut]
    private fun signOut() {
        mGoogleSignInClient?.signOut()?.addOnCompleteListener(this) {
            // [START_EXCLUDE]
            updateUI(null)
            // [END_EXCLUDE]
        }
    }
    // [END signOut]

    private fun updateUI(account: GoogleSignInAccount?) {

        if (account != null) {

            tvUserName?.setText(getString(R.string.signed_in_fmt, account.displayName))
            signInButton?.setVisibility(View.GONE)
            signOutButton?.visibility = View.VISIBLE
            gotoMainActivityButton?.visibility = View.VISIBLE

        } else {

            tvUserName?.setText(R.string.signed_out)
            signInButton?.visibility = View.VISIBLE
            signOutButton?.visibility = View.GONE
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.sign_in_button -> signIn()
            R.id.sign_out_button -> signOut()
            R.id.goto_mainactivity_button -> goToMainActivity()
        }
    }

    private fun goToMainActivity() {

        val intent = Intent(this, AccountListActivity::class.java)
        startActivity(intent)
    }
}


