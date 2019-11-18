package com.example.soccerapps.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soccerapps.R
import com.example.soccerapps.view.fragment.main.EventFragment
import com.example.soccerapps.view.fragment.main.FavoriteFragment
import com.example.soccerapps.view.fragment.main.LeagueFragment
import kotlinx.android.synthetic.main.bottom_nav_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homes -> {
                    addLeagueFragment(savedInstanceState)
                }

                R.id.event -> {
                    addEventFragment(savedInstanceState)
                }

                R.id.favorite -> {
                    addFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.homes
    }

    private fun addLeagueFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_container,
                    LeagueFragment(),
                    LeagueFragment::class.java.simpleName
                )
                .commit()
        }
    }

    private fun addFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_container,
                    FavoriteFragment(),
                    FavoriteFragment::class.java.simpleName
                )
                .commit()
        }
    }

    private fun addEventFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, EventFragment(), EventFragment::class.java.simpleName)
                .commit()
        }
    }
}

