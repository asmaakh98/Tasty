package com.example.tasty

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tasty.fragments.FavoritesFragment
import com.example.tasty.fragments.HomeFragment
import com.example.tasty.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottom_navigation: BottomNavigationView
    lateinit var homeFragment: HomeFragment
    lateinit var favFragment: FavoritesFragment
    lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var frame = findViewById<FrameLayout>(R.id.fl_wrapper)

        setupActionBarWithNavController(findNavController(R.id.fragment))


        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_wrapper, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomnav.setOnNavigationItemSelectedListener { item ->
            //we will select each menu item and add an event when it's selected
            when (item.itemId) {
                R.id.home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_wrapper, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.favorite -> {
                    favFragment = FavoritesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_wrapper, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.settings -> {
                    settingsFragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_wrapper, settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
