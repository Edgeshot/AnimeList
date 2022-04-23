package com.wnadeem.animelist

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.wnadeem.animelist.R
import com.wnadeem.animelist.AnimeList.Companion.SHOW_MESSAGE_AT_START
import com.wnadeem.animelist.AnimeList.Companion.SHOW_MESSAGE_AT_START1
import com.wnadeem.animelist.AnimeList.Companion.SHOW_MESSAGE_AT_START2


class MainActivity2 : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment

    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)

        if (savedInstanceState == null) {
            if (prefs.getBoolean(SHOW_MESSAGE_AT_START2, false)) {
                welcomeAlert3()

            }
            if (prefs.getBoolean(SHOW_MESSAGE_AT_START1, false)) {

                welcomeAlert2()
            }
            if (prefs.getBoolean(SHOW_MESSAGE_AT_START, false)) {

                welcomeAlert()
            }
        }


        val navController = findNavController(R.id.navHostFragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_notifications,
                R.id.navigation_dashboard,
                R.id.navigation_home
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.navHostFragment).navigateUp()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_items -> {
                navHostFragment.navController.navigate(R.id.action_navigation_home_to_settingsFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun welcomeAlert() {
        val msg = resources.getString(R.string.welcome)
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.welcome)
            setMessage(R.string.purpose)
            setIcon(R.drawable.pikachuicon)
            setPositiveButton(R.string.ok, null)
            show()
        }
    }

    private fun welcomeAlert2() {
        val msg = resources.getString(R.string.welcome)
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.Tip)
            setMessage(R.string.TipText)
            setIcon(R.drawable.ic_baseline_highlight_24)
            setPositiveButton(R.string.ok, null)
            show()
        }
    }

    private fun welcomeAlert3() {
        val msg = resources.getString(R.string.welcome)
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.Devlog)
            setMessage(R.string.Devlogtext)
            setIcon(R.drawable.ic_baseline_handyman_24)
            setPositiveButton(R.string.ok, null)
            show()
        }
    }
}