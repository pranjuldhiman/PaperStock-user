package com.macamp.paperstock.ui.activities

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.macamp.paperstock.R


class DashboardActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    val policy by lazy { ThreadPolicy.Builder().permitAll().build() }
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        // Nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment

        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(bottomNav, navHostFragment.navController)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.watchListBtn, R.id.tradeBtn, R.id.portfolioBtn, R.id.accountBtn)
//        )


//        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
//                || super.onOptionsItemSelected(item)
    }
//
//
//    override fun onSupportNavigateUp(): Boolean {
//
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.main_nav_host).navigateUp(appBarConfiguration)
//    }

}