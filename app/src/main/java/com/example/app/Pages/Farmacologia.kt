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
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.Pages.PopUp_Farmacologia.PopUp_Farmacologia
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

        //Para abrir el PopUp
        val imgindicaciones : ImageView = findViewById(R.id.ImgIndicaciones)
        imgindicaciones.setOnClickListener{
            val intent = Intent(this, PopUp_Farmacologia::class.java)
            startActivity(intent)
        }



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
                val contenedor4: LinearLayout = findViewById(R.id.layoutIndicaciones)
                contenedor1.visibility = View.VISIBLE
                contenedor2.visibility = View.VISIBLE
                contenedor3.visibility = View.VISIBLE
                contenedor4.visibility = View.VISIBLE



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
            val contenedor4: LinearLayout = findViewById(R.id.layoutIndicaciones)
            contenedor1.visibility = View.VISIBLE
            contenedor2.visibility = View.VISIBLE
            contenedor3.visibility = View.VISIBLE
            contenedor4.visibility = View.VISIBLE



            val farmaco1_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco1_dosis: TextView = findViewById(R.id.dosis)
            val farmaco2_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco2_dosis: TextView = findViewById(R.id.dosis)
            val farmaco3_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco3_dosis: TextView = findViewById(R.id.dosis)
            val farmaco4_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco4_dosis: TextView = findViewById(R.id.dosis)
            val farmaco5_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco5_dosis: TextView = findViewById(R.id.dosis)
            val farmaco6_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco6_dosis: TextView = findViewById(R.id.dosis)
            val farmaco7_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco7_dosis: TextView = findViewById(R.id.dosis)
            val farmaco8_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco8_dosis: TextView = findViewById(R.id.dosis)
            val farmaco9_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco9_dosis: TextView = findViewById(R.id.dosis)
            val farmaco10_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco10_dosis: TextView = findViewById(R.id.dosis)
            val farmaco11_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco11_dosis: TextView = findViewById(R.id.dosis)
            val farmaco12_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco12_dosis: TextView = findViewById(R.id.dosis)
            val farmaco13_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco13_dosis: TextView = findViewById(R.id.dosis)
            val farmaco14_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco14_dosis: TextView = findViewById(R.id.dosis)
            val farmaco15_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco15_dosis: TextView = findViewById(R.id.dosis)
            val farmaco16_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco16_dosis: TextView = findViewById(R.id.dosis)
            val farmaco17_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco17_dosis: TextView = findViewById(R.id.dosis)
            val farmaco18_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco18_dosis: TextView = findViewById(R.id.dosis)
            val farmaco19_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco19_dosis: TextView = findViewById(R.id.dosis)
            val farmaco20_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco20_dosis: TextView = findViewById(R.id.dosis)
            val farmaco21_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco21_dosis: TextView = findViewById(R.id.dosis)
            val farmaco22_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco22_dosis: TextView = findViewById(R.id.dosis)
            val farmaco23_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco23_dosis: TextView = findViewById(R.id.dosis)
            val farmaco24_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco24_dosis: TextView = findViewById(R.id.dosis)
            val farmaco25_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco25_dosis: TextView = findViewById(R.id.dosis)
            val farmaco26_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco26_dosis: TextView = findViewById(R.id.dosis)
            val farmaco27_indi: TextView = findViewById(R.id.indicaciones)
            val farmaco27_dosis: TextView = findViewById(R.id.dosis)
            // Realizar comparación para mostrar el botón de dosis si se selecciona un fármaco específico
            when (selectedItem) {

                "Abamectina" -> {
                    farmaco1_indi.text = getString(R.string.farma1_indicaciones)
                    farmaco1_dosis.text = getString(R.string.farma1_dosis)
                }


                "Amoxicilina" -> {
                    farmaco2_indi.text = getString(R.string.farma2_indicaciones)
                    farmaco2_dosis.text = getString(R.string.farma2_dosis)
                }

                "Amoxicilina" -> {
                    farmaco3_indi.text = getString(R.string.farma3_indicaciones)
                    farmaco3_dosis.text = getString(R.string.farma3_dosis)
                }

                "Buserelina acetato" -> {
                    farmaco4_indi.text = getString(R.string.farma4_indicaciones)
                    farmaco4_dosis.text = getString(R.string.farma4_dosis)
                }

                "Cefalexina monohidrato" -> {
                    farmaco5_indi.text = getString(R.string.farma5_indicaciones)
                    farmaco5_dosis.text = getString(R.string.farma5_dosis)
                }

                "Ciprofloxacina" -> {
                    farmaco6_indi.text = getString(R.string.farma6_indicaciones)
                    farmaco6_dosis.text = getString(R.string.farma6_dosis)
                }

                "Closantel" -> {
                    farmaco7_indi.text = getString(R.string.farma7_indicaciones)
                    farmaco7_dosis.text = getString(R.string.farma7_dosis)
                }

                "Diazinón" -> {
                    farmaco8_indi.text = getString(R.string.farma8_indicaciones)
                    farmaco8_dosis.text = getString(R.string.farma8_dosis)
                }

                "Eprinomectina" -> {
                    farmaco9_indi.text = getString(R.string.farma9_indicaciones)
                    farmaco9_dosis.text = getString(R.string.farma9_dosis)
                }

                "Fenilbutazona" -> {
                    farmaco10_indi.text = getString(R.string.farma10_indicaciones)
                    farmaco10_dosis.text = getString(R.string.farma10_dosis)
                }

                "Fenilbutazona, Dexametasona" -> {
                    farmaco11_indi.text = getString(R.string.farma11_indicaciones)
                    farmaco11_dosis.text = getString(R.string.farma11_dosis)
                }

                "Fipronil" -> {
                    farmaco12_indi.text = getString(R.string.farma12_indicaciones)
                    farmaco12_dosis.text = getString(R.string.farma12_dosis)
                }

                "Florfenicol" -> {
                    farmaco13_indi.text = getString(R.string.farma13_indicaciones)
                    farmaco13_dosis.text = getString(R.string.farma13_dosis)
                }
                "Gluconato de Calcio" -> {
                    farmaco14_indi.text = getString(R.string.farma14_indicaciones)
                    farmaco14_dosis.text = getString(R.string.farma14_dosis)
                }

                "Ivermectina" -> {
                    farmaco15_indi.text = getString(R.string.farma15_indicaciones)
                    farmaco15_dosis.text = getString(R.string.farma15_dosis)
                }

                "Ketamina" -> {
                    farmaco16_indi.text = getString(R.string.farma16_indicaciones)
                    farmaco16_dosis.text = getString(R.string.farma16_dosis)
                }

                "Neomicina"  -> {
                    farmaco17_indi.text = getString(R.string.farma17_indicaciones)
                    farmaco17_dosis.text = getString(R.string.farma17_dosis)
                }
                "Nitroxinil" -> {
                    farmaco18_indi.text = getString(R.string.farma18_indicaciones)
                    farmaco18_dosis.text = getString(R.string.farma18_dosis)
                }

                "Oxitetraciclina" -> {
                    farmaco19_indi.text = getString(R.string.farma19_indicaciones)
                    farmaco19_dosis.text = getString(R.string.farma19_dosis)
                }

                "Oxitocina" -> {
                    farmaco20_indi.text = getString(R.string.farma20_indicaciones)
                    farmaco20_dosis.text = getString(R.string.farma20_dosis)
                }

                "Pentobarbital sódico" -> {
                    farmaco21_indi.text = getString(R.string.farma21_indicaciones)
                    farmaco21_dosis.text = getString(R.string.farma21_dosis)
                }
                "Praziquantel" -> {
                    farmaco22_indi.text = getString(R.string.farma22_indicaciones)
                    farmaco22_dosis.text = getString(R.string.farma22_dosis)
                }
                "Sulfato de cefquinoma" -> {
                    farmaco23_indi.text = getString(R.string.farma23_indicaciones)
                    farmaco23_dosis.text = getString(R.string.farma23_dosis)
                }
                "Triclabendazol" -> {
                    farmaco24_indi.text = getString(R.string.farma24_indicaciones)
                    farmaco24_dosis.text = getString(R.string.farma24_dosis)
                }
                "Vitamina A" -> {
                    farmaco25_indi.text = getString(R.string.farma25_indicaciones)
                    farmaco25_dosis.text = getString(R.string.farma25_dosis)
                }
                "Vitamina C" -> {
                    farmaco26_indi.text = getString(R.string.farma26_indicaciones)
                    farmaco26_dosis.text = getString(R.string.farma26_dosis)
                }
                "Xilazina" -> {
                    farmaco27_indi.text = getString(R.string.farma27_indicaciones)
                    farmaco27_dosis.text = getString(R.string.farma27_dosis)
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