package com.macamp.paperstock.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.macamp.paperstock.R
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import com.google.gson.Gson
import com.macamp.paperstock.data.NSERequest
import com.macamp.paperstock.utils.Constants
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import timber.log.Timber
import java.net.URI
import javax.net.ssl.SSLSocketFactory


class DashboardActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    val policy by lazy { ThreadPolicy.Builder().permitAll().build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment

        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.main_nav_graph)
        navGraph.startDestination = R.id.dashboardFragment
        navController.graph = navGraph

        setupBottomNavMenu(navController = navController)

//        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)




        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.watchListBtn, R.id.tradeBtn, R.id.portfolioBtn, R.id.accountBtn)
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.main_nav_host))
                || super.onOptionsItemSelected(item)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.main_nav_host).navigateUp(appBarConfiguration)
    }

}