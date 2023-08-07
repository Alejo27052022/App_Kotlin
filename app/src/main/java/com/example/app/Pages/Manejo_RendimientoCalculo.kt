package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
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
import com.example.app.databinding.ActivityRendimientoCalculoBinding
import com.google.android.material.navigation.NavigationView

class Manejo_RendimientoCalculo : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityRendimientoCalculoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRendimientoCalculoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("Aberdeen Angus", "Brahmán", "Charolais", "Hereford", "Limousin", "Nelore", "Brow Swiss", "Holstein", "Normado", "Jersey", "Gando de Lidia");
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        binding.dropdownMenuFieldRaza.setAdapter(adapter)

        val sexo = listOf("Macho", "Hembra")
        val adapter_sexo = ArrayAdapter(this, R.layout.list_item, sexo)
        binding.dropdownMenuFieldSexo.setAdapter(adapter_sexo)

        /* Variables de los botones */
        val btn_calcular : Button = findViewById(R.id.btn_calcular)

        /* Button Calcular */
        btn_calcular.setOnClickListener{Calcular()}

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val regresar : ImageView = findViewById(R.id.regresar)
        regresar.setOnClickListener{
            val intent = Intent(this, Manejo_Inicio::class.java)
            startActivity(intent)
        }

    }

    private fun Calcular(){
        val raza_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_raza)
        var raza: String = raza_select.text.toString()

        val sexo_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_sexo)
        var sexo: String = sexo_select.text.toString()

        var peso_ingresado: EditText = findViewById(R.id.txtPeso)
        var peso: Double = peso_ingresado.text.toString().toDouble()
// Verificar si se ha seleccionado una raza
        if (raza.isBlank()) {
            Toast.makeText(this, "Por favor, seleccione una raza", Toast.LENGTH_SHORT).show()
            return
        }

// Verificar si se ha seleccionado un sexo
        if (sexo.isBlank()) {
            Toast.makeText(this, "Por favor, seleccione un sexo", Toast.LENGTH_SHORT).show()
            return
        }

// Verificar si se ha ingresado un peso
        if (peso == null) {
            Toast.makeText(this, "Por favor, ingrese un peso válido", Toast.LENGTH_SHORT).show()
            return
        }
        var resultado_kilo: TextView = findViewById(R.id.resultado_kilo)
        var resultado_libra: TextView = findViewById(R.id.resultado_libra)


        when (raza){
            "Aberdeen Angus" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((70.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((70.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((65.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((65.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
            }

            "Brahmán" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((65.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((65.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Charolais" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((63.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((63.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Hereford" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((60.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((60.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }

            }

            "Limousin" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Nelore" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((54.60/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((54.60/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((50.80/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((50.80/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Brow Swiss" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((51.29/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((51.29/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((51.29/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((51.29/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Holstein" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((56.41/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.41/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((56.07/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.07/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Normado" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((56.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Jersey" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((63.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((63.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

            "Gando de Lidia" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((62.45/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((62.45/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_kilo.text = String.format("%.2f",rendimiento_kilo)
                    resultado_libra.text = String.format("%.2f",rendimiento_libra)

                }
            }

        }
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