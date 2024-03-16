package com.powerclick.app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.powerclick.app.databinding.ActivityMainBinding
import com.powerclick.app.shared_preferences.OnboardingSharedPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)

        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        window.decorView.setOnApplyWindowInsetsListener { view, windowInsets ->
            windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
            view.onApplyWindowInsets(windowInsets)
        }

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
//
//        val onboardingSharedPreferences = OnboardingSharedPreferences(this)
//
//        val isOnboardingCompleted = onboardingSharedPreferences.isOnboardingCompleted()
//
//        if (!isOnboardingCompleted) {
//            changeFragment(R.id.onboardingFragment)
//        } else {
//            changeFragment(R.id.Scanner)
//        }
        setupWithNavController(binding.bottombar, navController)
        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, id, _ ->
                binding.bottombar.visibility =
                    when (id.id) {
                        R.id.onboardingFragment, R.id.slpashScreenFragment -> View.GONE
                        else -> View.VISIBLE
                    }

            }

        binding.bottombar.setOnItemSelectedListener  { menuItem ->
            when (menuItem.itemId) {
                R.id.Command -> {
                    changeFragment(R.id.commandFragment)
                    true
                }
                R.id.Scanner -> {
                    changeFragment(R.id.scannerFragment)
                    true
                }
                R.id.Support -> {
                    changeFragment(R.id.aboutFragment)
                    true
                }
                else -> false
            }
        }

    }
    private fun changeFragment(id: Int) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(id)
    }
}