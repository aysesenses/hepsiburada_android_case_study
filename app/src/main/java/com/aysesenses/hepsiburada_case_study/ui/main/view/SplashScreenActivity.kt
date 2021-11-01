package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.window.SplashScreenView
import androidx.appcompat.app.AppCompatActivity
import com.aysesenses.hepsiburada_case_study.R

class SplashScreenActivity : AppCompatActivity() {

    private val splashImage by lazy { findViewById<View>(R.id.splash_image) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        splashImage.alpha = 0f
        splashImage.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}