 package com.example.navigationtest

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

 class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appbarConfig: AppBarConfiguration
    private lateinit var listener:NavController.OnDestinationChangedListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      DRAWER
        navController = findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setupWithNavController(navController)
        appbarConfig = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appbarConfig)

        listener =  NavController.OnDestinationChangedListener{controller, destination, arguments ->
            if (destination.id == R.id.firstFragment) {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_primary_dark)))
            }else if (destination.id == R.id.secondFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_error)))
            }
        }
//        END DRAWER
    }

     override fun onResume() {
         super.onResume()
//         DRAWER
         navController.removeOnDestinationChangedListener(listener)
     }

     override fun onPause() {
         super.onPause()
//         DRAWER
         navController.removeOnDestinationChangedListener(listener)
     }

     override fun onSupportNavigateUp(): Boolean {
//         DRAWER   
         val navController = findNavController(R.id.fragment)
         return navController.navigateUp(appbarConfig)
                 || super.onSupportNavigateUp()
     }
 }