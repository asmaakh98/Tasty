package com.example.tasty

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tasty.database.Recipe
import com.example.tasty.fragments.HomeFragment
import com.example.tasty.fragments.MyRecipesFragment
import com.example.tasty.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottom_navigation: BottomNavigationView
    lateinit var myRecipesFragment: MyRecipesFragment
    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var frame = findViewById<FrameLayout>(R.id.fl_wrapper)



        setupActionBarWithNavController(findNavController(R.id.fragment))


        myRecipesFragment = MyRecipesFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_wrapper, myRecipesFragment)
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
                R.id.my_recipes -> {
                    myRecipesFragment = MyRecipesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_wrapper, myRecipesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_wrapper, profileFragment)
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
