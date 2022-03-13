package com.example.superstoreapp.ui.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.superstoreapp.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController = Navigation.findNavController(this, R.id.fragment_nav_container)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)


        //for bottom navigation notification
        val bottomNavigationMenuView =
            bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val v = bottomNavigationMenuView.getChildAt(1)
        val itemView = v as BottomNavigationItemView

        val badge: View =
            LayoutInflater.from(this).inflate(R.layout.notification_badge, itemView, true)
        val notification = badge.findViewById<TextView>(R.id.bottom_navigation_notification)
        notification.text = "55"
    }
}