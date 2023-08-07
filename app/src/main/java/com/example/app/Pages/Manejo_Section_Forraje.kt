package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Manejo_Section_Forraje : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manejo_forraje)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val button_forraje: Button = findViewById(R.id.btn_forraje)
        button_forraje.setOnClickListener{
            Calcular()
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

    private fun Calcular(){
        val constante_animal : Double= 400.0;
        val Num_Animal : EditText = findViewById(R.id.Num_Anim)
        var num : Double = Num_Animal.text.toString().toDouble()

        val Peso_Forraje : EditText = findViewById(R.id.Peso_Forraje)
        var peso : Double = Peso_Forraje.text.toString().toDouble()

        val Hectareas : EditText = findViewById(R.id.Hectareas)
        var hectareas_num : Double = Hectareas.text.toString().toDouble()
        // Verificar si los EditText están vacíos
        if (Num_Animal.text.isBlank() || Peso_Forraje.text.isBlank() || Hectareas.text.isBlank()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }
        // Verificar si el valor de Hectareas es cero o negativo
        if (hectareas_num <= 0.0) {
            Toast.makeText(this, "El valor de las hectáreas debe ser mayor que cero", Toast.LENGTH_SHORT).show()
            return
        }

        var res_hectareas : TextView = findViewById(R.id.Res_An_Hectareas)
        var res_animal : TextView = findViewById(R.id.Res_Animal)

        var resultado_animal : Double = (peso/constante_animal)
        res_animal.text = String.format("%.2f", resultado_animal)

        var resultado_hectareas: Double = (resultado_animal * num)/hectareas_num
        res_hectareas.text = String.format("%.2f", resultado_hectareas)

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