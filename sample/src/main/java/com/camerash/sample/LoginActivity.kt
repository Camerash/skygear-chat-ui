package com.camerash.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ChatHelper.skygearLogin(this, "hnwongab", object: ChatHelper.SkygearLoginCallback {
            override fun onLoginSuccess() {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }

            override fun onLoginFailed() {
                finish()
            }
        })
    }
}
