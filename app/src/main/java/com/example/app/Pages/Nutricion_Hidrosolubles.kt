package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB1
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB10
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB12
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB2
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB6
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB7
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaB8
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaC
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Nutricion_Hidrosolubles : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutricion_vitaminas_hidrosolubles)

        val vita_b1 : FrameLayout = findViewById(R.id.frame_vitaB1)
        vita_b1.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB1::class.java)
            startActivity(intent)
        }

        val vita_b2 : FrameLayout = findViewById(R.id.frame_vitaB2)
        vita_b2.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB2::class.java)
            startActivity(intent)
        }

        val vita_b12 : FrameLayout = findViewById(R.id.frame_vitaB12)
        vita_b12.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB12::class.java)
            startActivity(intent)
        }

        val vita_c : FrameLayout = findViewById(R.id.frame_vitaC)
        vita_c.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaC::class.java)
            startActivity(intent)
        }

        val vita_b6 : FrameLayout = findViewById(R.id.frame_vitaB6)
        vita_b6.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB6::class.java)
            startActivity(intent)
        }

        val vita_b7 : FrameLayout = findViewById(R.id.frame_vitaB7)
        vita_b7.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB7::class.java)
            startActivity(intent)
        }

        val vita_b8 : FrameLayout = findViewById(R.id.frame_vitaB8)
        vita_b8.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB8::class.java)
            startActivity(intent)
        }

        val vita_b10 : FrameLayout = findViewById(R.id.frame_vitaB10)
        vita_b10.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaB10::class.java)
            startActivity(intent)
        }

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.home_option -> {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            R.id.farmacologia_option -> {
                val intent = Intent(this, Farmacologia_Inicio::class.java)
                startActivity(intent)
            }
            R.id.nutricion_option -> {
                val intent = Intent (this, Nutricion::class.java)
                startActivity(intent)
            }
            R.id.manejo_option -> {
                val intent = Intent(this, Manejo::class.java)
                startActivity(intent)
            }
            R.id.reproduccion_option ->{
                val intent = Intent(this, Reproduccion_Inicio::class.java)
                startActivity(intent)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}