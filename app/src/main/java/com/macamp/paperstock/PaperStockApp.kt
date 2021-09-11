package com.macamp.paperstock

import android.app.Application

class PaperStockApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
private val contextApplication = PaperStockApp()
        fun getInstance() : PaperStockApp{

            return contextApplication
        }
    }
}