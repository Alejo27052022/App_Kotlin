package com.example.app.Pages
import android.content.Intent
import android.content.res.Configuration
import android.widget.TextView
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.google.android.material.navigation.NavigationView


class Farmacologia: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var autoComplete: AutoCompleteTextView
    private lateinit var dosisButton: Button
    private lateinit var spinner: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinnerAdapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.farmacologia)

        spinner = findViewById(R.id.spinner)
        spinner2 = findViewById(R.id.spinner2)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        val options = resources.getStringArray(R.array.options_array)
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter


        val options2 = resources.getStringArray(R.array.options_array2)
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options2)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = spinnerAdapter



        fun calcularDosis(view: View) {



            val pesoAnimalEditText = findViewById<EditText>(R.id.pesoanimal)
            val dosisMedicaEditText = findViewById<EditText>(R.id.dosismedica)
            val concentracionMedEditText = findViewById<EditText>(R.id.concentracionmed)
            val resultadoTextView = findViewById<TextView>(R.id.textView4)

            // Obtener los valores ingresados
            val pesoAnimalText = pesoAnimalEditText.text.toString()
            val dosisMedicaText = dosisMedicaEditText.text.toString()
            val concentracionMedText = concentracionMedEditText.text.toString()

            // Verificar si algún campo está vacío
            if (pesoAnimalText.isEmpty() || dosisMedicaText.isEmpty() || concentracionMedText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese todos los datos requeridos", Toast.LENGTH_SHORT).show()
                return
            }

            // Obtener los valores ingresados
            val pesoAnimal = pesoAnimalEditText.text.toString().toDouble()
            val dosisMedica = dosisMedicaEditText.text.toString().toDouble()
            val concentracionMed = concentracionMedEditText.text.toString().toDouble()
            // Verificar que los dividendos sean diferentes de cero
            if (dosisMedica == 0.0 || concentracionMed == 0.0) {
                Toast.makeText(this, "Los dividendos deben ser diferentes de cero", Toast.LENGTH_SHORT).show()
                return
            }
// ...

            // Realizar el cálculo
            val resultado = String.format("%.2f", ((pesoAnimal * dosisMedica) / concentracionMed))

            // Mostrar el resultado
            resultadoTextView.text = resultado.toString()


            // Obtener la opción seleccionada en el primer Spinner
            val seleccionSpinner1 = spinner.selectedItem.toString()

            // Obtener la opción seleccionada en el segundo Spinner
            val seleccionSpinner2 = spinner2.selectedItem.toString()

            // Construir el texto a mostrar en el resultado
            val textoResultado = "Dosis: $resultado $seleccionSpinner2/$seleccionSpinner1"

            // Mostrar el resultado
            resultadoTextView.text = textoResultado

            // AÑADI ESTA PARTE DEL CÓDIGO PARA LA LIMPIEZA DE LOS VALORES
            autoComplete.setOnItemClickListener { _, _, _, _ ->
                val selectedItem = autoComplete.text.toString()

                // Reiniciar los campos de entrada
                pesoAnimalEditText.text.clear()
                dosisMedicaEditText.text.clear()
                concentracionMedEditText.text.clear()

                // Reiniciar el resultado
                resultadoTextView.text = ""

                // Hacer visible el botón de dosis cuando se haga clic en un medicamento
                dosisButton.visibility = Button.VISIBLE

                // Hace visible los contenedores(LinerLayout)
                val contenedor1: LinearLayout = findViewById(R.id.layout1)
                val contenedor2: LinearLayout = findViewById(R.id.layout2)
                val contenedor3: LinearLayout = findViewById(R.id.layout3)
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE

                // ... (Resto del código)


            }

        }

        val items = listOf(
            "Abamectina",
            "Amoxicilina",
            "Amoxicilina",
            "Buserelina acetato",
            "Cefalexina monohidrato",
            "Ciprofloxacina",
            "Closantel",
            "Diazinón",
            "Eprinomectina",
            "Fenilbutazona, Dexametasona",
            "Fipronil, Fluazurón ",
            "Florfenicol",
            "Gluconato de Calcio",
            "Ivermectina",
            "Ketamina",
            "Neomicina",
            "Nitroxinil",
            "Oxitetraciclina",
            "Oxitocina",
            "Pentobarbital sódico",
            "Praziquantel",
            "Sulfato de cefquinoma",
            "Triclabendazol",
            "Vitamina A",
            "Vitamina C",
            "Xilazina"

        )

        autoComplete = findViewById(R.id.auto_complete)
        dosisButton = findViewById(R.id.dosisButton)
        findViewById<Button>(R.id.dosisButton)
        dosisButton.setOnClickListener {
            calcularDosis(it)
        }

        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)

        autoComplete.setOnItemClickListener { _, _, _, _ ->
            val selectedItem = autoComplete.text.toString()

            // Hacer visible el botón de dosis cuando de clic en un medicamento
            dosisButton.visibility = Button.VISIBLE

            //Hace visible los contenedores(LinerLayout)
            val contenedor1: LinearLayout = findViewById(R.id.layout1)
            val contenedor2: LinearLayout = findViewById(R.id.layout2)
            val contenedor3: LinearLayout = findViewById(R.id.layout3)
            contenedor1.visibility = View.VISIBLE
            contenedor2.visibility = View.VISIBLE
            contenedor3.visibility = View.VISIBLE



            val farmaco1: TextView = findViewById(R.id.farmaco)
            val farmaco2: TextView = findViewById(R.id.farmaco)
            val farmaco3: TextView = findViewById(R.id.farmaco)
            val farmaco4: TextView = findViewById(R.id.farmaco)
            val farmaco5: TextView = findViewById(R.id.farmaco)
            val farmaco6: TextView = findViewById(R.id.farmaco)
            val farmaco7: TextView = findViewById(R.id.farmaco)
            val farmaco8: TextView = findViewById(R.id.farmaco)
            val farmaco9: TextView = findViewById(R.id.farmaco)
            val farmaco10: TextView = findViewById(R.id.farmaco)
            val farmaco11: TextView = findViewById(R.id.farmaco)
            val farmaco12: TextView = findViewById(R.id.farmaco)
            val farmaco13: TextView = findViewById(R.id.farmaco)
            val farmaco14: TextView = findViewById(R.id.farmaco)
            val farmaco15: TextView = findViewById(R.id.farmaco)
            val farmaco16: TextView = findViewById(R.id.farmaco)
            val farmaco17: TextView = findViewById(R.id.farmaco)
            val farmaco18: TextView = findViewById(R.id.farmaco)
            val farmaco19: TextView = findViewById(R.id.farmaco)
            val farmaco20: TextView = findViewById(R.id.farmaco)
            val farmaco21: TextView = findViewById(R.id.farmaco)
            val farmaco22: TextView = findViewById(R.id.farmaco)
            val farmaco23: TextView = findViewById(R.id.farmaco)
            val farmaco24: TextView = findViewById(R.id.farmaco)
            val farmaco25: TextView = findViewById(R.id.farmaco)
            val farmaco26: TextView = findViewById(R.id.farmaco)
            val farmaco27: TextView = findViewById(R.id.farmaco)
            // Realizar comparación para mostrar el botón de dosis si se selecciona un fármaco específico
            when (selectedItem) {

                "Abamectina" -> {
                    farmaco1.text = getString(R.string.farma1)

                }


                "Amoxicilina" -> {
                    farmaco2.text = getString(R.string.farma2)

                }

                "Amoxicilina" -> {
                    farmaco3.text = getString(R.string.farma3)

                }

                "Buserelina acetato" -> {
                    farmaco4.text = getString(R.string.farma4)

                }

                "Cefalexina monohidrato" -> {
                    farmaco5.text = getString(R.string.farma5)

                }

                "Ciprofloxacina" -> {
                    farmaco6.text = getString(R.string.farma6)


                }

                "Closantel" -> {
                    farmaco7.text = getString(R.string.farma7)

                }

                "Diazinón" -> {
                    farmaco8.text = getString(R.string.farma8)

                }

                "Eprinomectina" -> {
                    farmaco9.text = getString(R.string.farma9)

                }

                "Fenilbutazona" -> {
                    farmaco10.text = getString(R.string.farma10)

                }

                "Fenilbutazona, Dexametasona" -> {
                    farmaco11.text = getString(R.string.farma11)

                }

                "Fipronil" -> {
                    farmaco12.text = getString(R.string.farma12)

                }

                "Florfenicol" -> {
                    farmaco13.text = getString(R.string.farma13)

                }
                "Gluconato de Calcio" -> {
                    farmaco14.text = getString(R.string.farma14)

                }

                "Ivermectina" -> {
                    farmaco15.text = getString(R.string.farma15)

                }

                "Ketamina" -> {
                    farmaco16.text = getString(R.string.farma16)

                }

                "Neomicina"  -> {
                    farmaco17.text = getString(R.string.farma17)

                }
                "Nitroxinil" -> {
                    farmaco18.text = getString(R.string.farma18)

                }

                "Oxitetraciclina" -> {
                    farmaco19.text = getString(R.string.farma19)

                }

                "Oxitocina" -> {
                    farmaco20.text = getString(R.string.farma20)

                }

                "Pentobarbital sódico" -> {
                    farmaco21.text = getString(R.string.farma21)

                }
                "Praziquantel" -> {
                    farmaco22.text = getString(R.string.farma22)

                }
                "Sulfato de cefquinoma" -> {
                    farmaco23.text = getString(R.string.farma23)

                }
                "Triclabendazol" -> {
                    farmaco24.text = getString(R.string.farma24)

                }
                "Vitamina A" -> {
                    farmaco25.text = getString(R.string.farma25)

                }
                "Vitamina C" -> {
                    farmaco26.text = getString(R.string.farma26)

                }
                "Xilazina" -> {
                    farmaco27.text = getString(R.string.farma27)

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
            R.id.farmacologia_option -> {
                val intent = Intent(this, Farmacologia::class.java)
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