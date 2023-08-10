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
import com.example.app.Pages.PopUp_Minerales.PopUp_Calcio
import com.example.app.Pages.PopUp_Minerales.PopUp_Cobalto
import com.example.app.Pages.PopUp_Minerales.PopUp_Fosforo
import com.example.app.Pages.PopUp_Minerales.PopUp_Hierro
import com.example.app.Pages.PopUp_Minerales.PopUp_Magnesio
import com.example.app.Pages.PopUp_Minerales.PopUp_Potasio
import com.example.app.Pages.PopUp_Minerales.PopUp_Selenio
import com.example.app.Pages.PopUp_Minerales.PopUp_Sodio
import com.example.app.Pages.PopUp_Minerales.PopUp_Zinc
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Nutricion_Minerales_Section : AppCompatActivity (), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutricion_minerales_secciones)

        val calcio : FrameLayout = findViewById(R.id.frame_calcio)
        calcio.setOnClickListener{
            val intent = Intent(this, PopUp_Calcio::class.java)
            startActivity(intent)
        }

        val cobalto : FrameLayout = findViewById(R.id.frame_cobalto)
        cobalto.setOnClickListener{
            val intent = Intent(this, PopUp_Cobalto::class.java)
            startActivity(intent)
        }

        val fosforo : FrameLayout = findViewById(R.id.frame_fosforo)
        fosforo.setOnClickListener{
            val intent = Intent(this, PopUp_Fosforo::class.java)
            startActivity(intent)
        }

        val hierro : FrameLayout = findViewById(R.id.frame_hierro)
        hierro.setOnClickListener{
            val intent = Intent(this, PopUp_Hierro::class.java)
            startActivity(intent)
        }

        val magnesio : FrameLayout = findViewById(R.id.frame_magnesio)
        magnesio.setOnClickListener{
            val intent = Intent(this, PopUp_Magnesio::class.java)
            startActivity(intent)
        }

        val potasio : FrameLayout = findViewById(R.id.frame_potasio)
        potasio.setOnClickListener{
            val intent = Intent(this, PopUp_Potasio::class.java)
            startActivity(intent)
        }

        val selenio : FrameLayout = findViewById(R.id.frame_selenio)
        selenio.setOnClickListener{
            val intent = Intent(this, PopUp_Selenio::class.java)
            startActivity(intent)
        }

        val sodio : FrameLayout = findViewById(R.id.frame_sodio)
        sodio.setOnClickListener{
            val intent = Intent(this, PopUp_Sodio::class.java)
            startActivity(intent)
        }

        val yodo : FrameLayout = findViewById(R.id.frame_yodo)
        yodo.setOnClickListener{
            val intent = Intent(this, PopUp_Sodio::class.java)
            startActivity(intent)
        }

        val zinc : FrameLayout = findViewById(R.id.frame_zinc)
        zinc.setOnClickListener{
            val intent = Intent(this, PopUp_Zinc::class.java)
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