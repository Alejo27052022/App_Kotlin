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
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaA
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaD
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaE
import com.example.app.Pages.PopUp_Vitaminas.PopUp_VitaminaK
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Nutricion_Liposolubles : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutricion_vitaminas_liposolubles)

        val pop_up_vitA : FrameLayout = findViewById(R.id.vitamina_a)
        pop_up_vitA.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaA::class.java)
            startActivity(intent)
        }

        val pop_up_vitD : FrameLayout = findViewById(R.id.vitamina_d)
        pop_up_vitD.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaD::class.java)
            startActivity(intent)
        }

        val pop_up_vitE : FrameLayout = findViewById(R.id.vitamina_e)
        pop_up_vitE.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaE::class.java)
            startActivity(intent)
        }

        val pop_up_vitK : FrameLayout = findViewById(R.id.vitamina_k)
        pop_up_vitK.setOnClickListener{
            val intent = Intent(this, PopUp_VitaminaK::class.java)
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
            R.id.farmacologia_option -> Toast.makeText(this, "Farmacologia", Toast.LENGTH_SHORT).show()
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