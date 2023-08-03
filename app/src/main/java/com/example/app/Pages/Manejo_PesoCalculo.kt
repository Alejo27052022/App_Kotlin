package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Manejo_PesoCalculo : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manejo_peso_calculo)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val button: Button = findViewById(R.id.btn_calcularpeso)
        button.setOnClickListener {
            calcularPeso()
        }

        val regresar : ImageView = findViewById(R.id.regresar)
        regresar.setOnClickListener{
            val intent = Intent(this, Manejo_Inicio::class.java)
            startActivity(intent)
        }

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    private fun calcularPeso() {
        val constantepeso = 10838
        val num1: EditText = findViewById(R.id.PTTEXT)
        val sumando: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.LCTEXT)
        val sumador: Double = num2.text.toString().toDouble()
        val suma: Double = sumando * sumando * sumador / constantepeso
        val resultado: TextView = findViewById(R.id.pesoresultado)
        resultado.text = String.format("%.2f",suma)
        val libras:Double=suma*2.2
        val resultadolibras: TextView = findViewById(R.id.pesoresultadolibras)
        resultadolibras.text = String.format("%.2f",libras)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.home_option -> {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            R.id.farmacologia_option -> Toast.makeText(this, "Farmacologia", Toast.LENGTH_SHORT).show()
            R.id.nutricion_option -> Toast.makeText(this, "Nutricion", Toast.LENGTH_SHORT).show()
            R.id.manejo_option -> {
                val intent = Intent(this, Manejo_Inicio::class.java)
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
