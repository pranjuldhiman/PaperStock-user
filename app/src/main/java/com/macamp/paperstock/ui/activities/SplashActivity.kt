package com.macamp.paperstock.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.macamp.paperstock.R
import com.macamp.paperstock.utils.Constants
import com.macamp.paperstock.utils.startActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
//                if (Preferences.prefs?.getString(TOKEN, "") != "1") {
                startActivity<DashboardActivity>()

//                } else {
//                    startActivity<LauncherActivity>()
//                }

            }
        }, Constants.SPLASH_DELAY)

    }
}