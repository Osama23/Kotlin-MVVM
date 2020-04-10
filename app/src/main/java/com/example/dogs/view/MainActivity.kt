package com.example.dogs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.dogs.R

class MainActivity : AppCompatActivity() {

    private lateinit var navConroller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navConroller = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navConroller)

    }

    // This will control back button
    override fun onSupportNavigateUp(): Boolean {
        // if we had drawer layout we should put it as the second parameter
        return NavigationUI.navigateUp(navConroller, null);

    }
}
