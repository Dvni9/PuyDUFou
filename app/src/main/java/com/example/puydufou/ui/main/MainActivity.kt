package com.example.puydufou.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.puydufou.R
import com.example.puydufou.databinding.ActivityMainBinding
import com.example.puydufou.ui.favorites.FavoritesFragment
import com.example.puydufou.ui.map.MapFragment
import com.example.puydufou.ui.settings.SettingsFragment
import com.example.puydufou.ui.shows.ShowsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()

        // Cargar el fragment inicial (ShowsFragment) solo la primera vez
        if (savedInstanceState == null) {
            loadFragment(ShowsFragment())
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.showsFragment -> {
                    loadFragment(ShowsFragment())
                    true
                }
                R.id.mapFragment -> {
                    loadFragment(MapFragment())
                    true
                }
                R.id.favoritesFragment -> {
                    loadFragment(FavoritesFragment())
                    true
                }
                R.id.settingsFragment -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Para poder volver atrás
            .commit()
    }
}