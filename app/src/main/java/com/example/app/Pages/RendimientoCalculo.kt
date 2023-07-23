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
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.example.app.databinding.ActivityRendimientoCalculoBinding
import com.google.android.material.navigation.NavigationView

class RendimientoCalculo : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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
        val home: ImageButton = findViewById(R.id.home)

        /* Button Calcular */
        btn_calcular.setOnClickListener{Calcular()}

        /* Direccionamiento de paginas */
        home.setOnClickListener{
            val intent: Intent = Intent(this, Inicio::class.java)
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

    private fun Calcular(){
        val raza_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_raza)
        var raza: String = raza_select.text.toString()

        val sexo_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_sexo)
        var sexo: String = sexo_select.text.toString()

        var peso_ingresado: EditText = findViewById(R.id.txtPeso)
        var peso: Double = peso_ingresado.text.toString().toDouble()

        var resultado_kilo: TextView = findViewById(R.id.resultado_kilo)
        var resultado_libra: TextView = findViewById(R.id.resultado_libra)


        when (raza){
            "Aberdeen Angus" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((70.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((70.00/100) * peso)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((65.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((65.00/100) * peso)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                }
            }

            "Brahmán" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((65.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((65.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Charolais" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((63.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((63.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Hereford" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((60.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((60.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }

            }

            "Limousin" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Nelore" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((54.60/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((54.60/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((50.80/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((50.80/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Brow Swiss" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((51.29/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((51.29/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((51.29/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((51.29/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Holstein" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((56.41/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.41/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((56.07/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.07/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Normado" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((56.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((56.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Jersey" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((63.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((63.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((55.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((55.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

            "Gando de Lidia" -> {
                if(sexo == "Macho"){
                    var rendimiento_libra: Double = (((62.45/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((62.45/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)
                }
                else if (sexo == "Hembra"){
                    var rendimiento_libra: Double = (((58.00/100) * peso) * 2.20462)
                    var rendimiento_kilo: Double = ((58.00/100) * peso)
                    resultado_libra.text = (" Peso en Libras es " + rendimiento_libra)
                    resultado_kilo.text = ("Peso en Kilogramos es " + rendimiento_kilo)

                }
            }

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.farmacologia_option -> Toast.makeText(this, "Farmacologia", Toast.LENGTH_SHORT).show()
            R.id.nutricion_option -> Toast.makeText(this, "Nutricion", Toast.LENGTH_SHORT).show()
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