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
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Bienestar
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Canal
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Comportamiento
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Manejo
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Ordeno
import com.example.app.Pages.PopUp_InfoManejo.PopUp_Pastoreo
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Manejo_Info : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manejo_informacion)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val bienestar : FrameLayout = findViewById(R.id.frame_bienestar)
        bienestar.setOnClickListener {
            val intent = Intent(this, PopUp_Bienestar::class.java)
            startActivity(intent)
        }

        val canal : FrameLayout = findViewById(R.id.frame_canal)
        canal.setOnClickListener {
            val intent = Intent(this, PopUp_Canal::class.java)
            startActivity(intent)
        }

        val comportamiento : FrameLayout = findViewById(R.id.frame_comportamiento)
        comportamiento.setOnClickListener {
            val intent = Intent(this, PopUp_Comportamiento::class.java)
            startActivity(intent)
        }

        val manejo : FrameLayout = findViewById(R.id.frame_manejo)
        manejo.setOnClickListener {
            val intent = Intent(this, PopUp_Manejo::class.java)
            startActivity(intent)
        }

        val ordeno : FrameLayout = findViewById(R.id.frame_ordeno)
        ordeno.setOnClickListener {
            val intent = Intent(this, PopUp_Ordeno::class.java)
            startActivity(intent)
        }

        val pastoreo : FrameLayout = findViewById(R.id.frame_pastoreo)
        pastoreo.setOnClickListener {
            val intent = Intent(this, PopUp_Pastoreo::class.java)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.home_option -> {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            R.id.farmacologia_option -> {
                val intent = Intent(this, Farmacologia_Inicio::class.java)
                startActivity(intent)}
            R.id.nutricion_option -> {
                val intent = Intent (this, Nutricion::class.java)
                startActivity(intent)
            }
            R.id.manejo_option -> {
                val intent = Intent(this, Manejo::class.java)
                startActivity(intent)

            }

            R.id.reproduccion_option -> Toast.makeText(this, "Reproduccion", Toast.LENGTH_SHORT).show()


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