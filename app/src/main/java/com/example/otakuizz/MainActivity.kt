package com.example.otakuizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.otakuizz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding.tvHello.text = getString(R.string.hello_payer)


        //incluye un controlador de navegacion. fragmentcontainerView2 es el host de navegación.
        val navFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navFragment.navController
        //establece la barra con controles
        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)


        //eventos de escucha del menú de navegación...
        binding.drawerNav.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.rules_menu -> {
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://example.google.app/rulesFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.about_menu -> {
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://example.google.app/aboutFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }
        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragmentContainerView2)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}