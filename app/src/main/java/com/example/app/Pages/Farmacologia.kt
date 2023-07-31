package com.example.app.Pages
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.app.R


class Farmacologia: AppCompatActivity() {
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




        }

        val items = listOf(
            "Amoxicilina",
            "Ampicilina",
            "Azitromicina",
            "Bacitracina",
            "Cefalexina",
            "Cefoperazona",
            "Cefradina",
            "Claritromicina",
            "Enrofloxacina",
            "Espiramicina",
            "Florfenicol",
            "Furaltadona",
            "Tiafenicol"
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

            // Realizar comparación para mostrar el botón de dosis si se selecciona un fármaco específico
            when (selectedItem) {

                "Amoxicilina" -> {
                    farmaco1.text = getString(R.string.farma1)

                }

                "Ampicilina" -> {
                    farmaco2.text = getString(R.string.farma2)

                }

                "Azitromicina" -> {
                    farmaco3.text = getString(R.string.farma3)

                }

                "Bacitracina" -> {
                    farmaco4.text = getString(R.string.farma4)

                }

                "Cefalexina" -> {
                    farmaco5.text = getString(R.string.farma5)

                }

                "Cefoperazona" -> {
                    farmaco6.text = getString(R.string.farma6)


                }

                "Cefradina" -> {
                    farmaco7.text = getString(R.string.farma7)

                }

                "Claritromicina" -> {
                    farmaco8.text = getString(R.string.farma8)

                }

                "Enrofloxacina" -> {
                    farmaco9.text = getString(R.string.farma9)

                }

                "Espiramicina" -> {
                    farmaco10.text = getString(R.string.farma10)

                }

                "Florfenicol" -> {
                    farmaco11.text = getString(R.string.farma11)

                }

                "Furaltadona" -> {
                    farmaco12.text = getString(R.string.farma12)

                }

                "Tiafenicol" -> {
                    farmaco13.text = getString(R.string.farma13)

                }

            }


        }
    }
}