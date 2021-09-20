package com.macamp.paperstock

import android.app.Application
import android.content.Context
import com.macamp.paperstock.utils.Preferences

class PaperStockApp: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        Preferences.initPreferences(this)
    }



    companion object {
        val Context.context: PaperStockApp
            get() = applicationContext as PaperStockApp

        lateinit var instance: PaperStockApp
//        lateinit var singleton: Singleton
//            private set
    }

}