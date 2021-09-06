package com.macamp.paperstock.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macamp.paperstock.R
import com.macamp.paperstock.utils.Constants
import com.macamp.paperstock.utils.startActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<LauncherActivity>()
            }
        }, Constants.SPLASH_DELAY)

    }
}