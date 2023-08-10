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


        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        //Para abrir el PopUp
        val imgindicaciones : ImageView = findViewById(R.id.ImgIndicaciones)
        imgindicaciones.setOnClickListener{
            val intent = Intent(this, PopUp_Farmacologia::class.java)
            

            val selectedItem = autoComplete.text.toString()

            intent.putExtra("selectedFarmaco", selectedItem)
            startActivity(intent)
        }


        spinner = findViewById(R.id.spinner)
        spinner2 = findViewById(R.id.spinner2)

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

            val spinner1 = findViewById<Spinner>(R.id.spinner)
            val spinner2 = findViewById<Spinner>(R.id.spinner2)

            // Obtener los valores ingresados
            val pesoAnimalText = pesoAnimalEditText.text.toString()
            val dosisMedicaText = dosisMedicaEditText.text.toString()
            val concentracionMedText = concentracionMedEditText.text.toString()

            // Verificar si algún campo está vacío
            if (pesoAnimalText.isEmpty() || dosisMedicaText.isEmpty() || concentracionMedText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese todos los datos requeridos", Toast.LENGTH_SHORT).show()
                return
            }

            // Obtener la opción seleccionada en el primer Spinner
            val seleccionSpinner1 = spinner1.selectedItem.toString()

            // Obtener la opción seleccionada en el segundo Spinner
            val seleccionSpinner2 = spinner2.selectedItem.toString()

            // Realizar conversiones de unidades según las selecciones de los Spinners
            val pesoAnimal = pesoAnimalText.toDouble()
            val dosisMedica = dosisMedicaText.toDouble()

            // Convertir dosis médica a mg si está en ml
            val dosisMedica_mg = if (seleccionSpinner2 == "ml") dosisMedica * 1000 else dosisMedica

            val concentracionMed = concentracionMedText.toDouble()

            // Verificar que los dividendos sean diferentes de cero
            if (dosisMedica_mg == 0.0 || concentracionMed == 0.0) {
                Toast.makeText(this, "Los dividendos deben ser diferentes de cero", Toast.LENGTH_SHORT).show()
                return
            }

            // Realizar el cálculo
            val dosisFinal = (pesoAnimal * dosisMedica_mg) / concentracionMed

            // Construir el texto a mostrar en el resultado
            val textoResultado = "Dosis: %.2f ml/kg".format(dosisFinal)

            // Mostrar el resultado
            resultadoTextView.text = textoResultado

            // Hacer visible los contenedores (LinearLayout)
            val contenedor1: LinearLayout = findViewById(R.id.layout1)
            val contenedor2: LinearLayout = findViewById(R.id.layout2)
            val contenedor3: LinearLayout = findViewById(R.id.layout3)
            val contenedor4: LinearLayout = findViewById(R.id.layoutIndicaciones)
            contenedor1.visibility = View.VISIBLE
            contenedor2.visibility = View.VISIBLE
            contenedor3.visibility = View.VISIBLE
            contenedor4.visibility = View.VISIBLE
        }




        autoComplete = findViewById(R.id.auto_complete)
        dosisButton = findViewById(R.id.dosisButton)
        findViewById<Button>(R.id.dosisButton)
        dosisButton.setOnClickListener {
            calcularDosis(it)
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



        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)

        autoComplete.setOnItemClickListener { _, _, _, _ ->


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

            val selectedItem = autoComplete.text.toString()
            val intent = Intent(this, PopUp_Farmacologia::class.java)
            intent.putExtra("selectedFarmaco", selectedItem)
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