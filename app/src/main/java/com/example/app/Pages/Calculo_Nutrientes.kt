package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.Pages.PopUp_Vitaminas.PopUp_Valor
import com.example.app.R
import com.google.android.material.navigation.NavigationView

class Calculo_Nutrientes : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    private lateinit var etMaiz: EditText
    private lateinit var etSorgo: EditText
    private lateinit var etTrigo: EditText
    private lateinit var etSalvadoTrigo: EditText
    private lateinit var etHarinaMaiz: EditText
    private lateinit var etHarinaSoya: EditText
    private lateinit var etCascarillaArroz: EditText

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutricion_calculo)

        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)
        etMaiz = findViewById(R.id.etMaiz)
        etSorgo = findViewById(R.id.etSorgo)
        etTrigo = findViewById(R.id.etTrigo)
        etSalvadoTrigo = findViewById(R.id.etSalvadoTrigo)
        etHarinaMaiz = findViewById(R.id.etHarinaMaiz)
        etHarinaSoya = findViewById(R.id.etHarinaSoya)
        etCascarillaArroz = findViewById(R.id.etCascarillaArroz)

        btnCalculate.setOnClickListener {
            calculateNutrients()
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

        val pop_pup : ImageButton = findViewById(R.id.popup)

        pop_pup.setOnClickListener{
            val intent = Intent(this, PopUp_Valor::class.java)
                startActivity(intent)
        }
    }

    private fun calculateNutrients() {
        val maiz = etMaiz.text.toString().toFloat()
        val sorgo = etSorgo.text.toString().toFloat()
        val trigo = etTrigo.text.toString().toFloat()
        val salvadoTrigo = etSalvadoTrigo.text.toString().toFloat()
        val harinaMaiz = etHarinaMaiz.text.toString().toFloat()
        val harinaSoya = etHarinaSoya.text.toString().toFloat()
        val cascarillaArroz = etCascarillaArroz.text.toString().toFloat()

        val total = maiz + sorgo + trigo + salvadoTrigo + harinaMaiz + harinaSoya + cascarillaArroz
        val kilogramosNecesarios = 100 - total

        tvResult.text = "$kilogramosNecesarios KG"
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.home_option -> {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            R.id.farmacologia_option -> {
                val intent = Intent(this, Farmacologia::class.java)
                startActivity(intent)}
            R.id.nutricion_option -> {
                val intent = Intent(this, Nutricion::class.java)
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