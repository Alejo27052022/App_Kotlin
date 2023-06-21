package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.app.R
import com.example.app.databinding.ActivityRendimientoCalculoBinding

class RendimientoCalculo : AppCompatActivity() {

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

        val unidad = listOf("Lb", "Kg")
        val adapter_unidad = ArrayAdapter(this, R.layout.list_item, unidad)
        binding.dropdownMenuFieldUnidad.setAdapter(adapter_unidad)

        /* Variables de los botones */
        val btn_calcular : Button = findViewById(R.id.btn_calcular)
        btn_calcular.setOnClickListener{Calcular()}

    }

    private fun Calcular(){
        val raza_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_raza)
        var raza: String = raza_select.text.toString()

        val sexo_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_sexo)
        var sexo: String = sexo_select.text.toString()

        val unidad_select: AutoCompleteTextView = findViewById(R.id.dropdown_menu_field_unidad)
        var unidad: String = unidad_select.text.toString()

        var peso_ingresado: EditText = findViewById(R.id.txtPeso)
        var peso: Double = peso_ingresado.text.toString().toDouble()

        var resultado: TextView = findViewById(R.id.resultado)


        when (raza){
            "Aberdeen Angus" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((70.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((65.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((70.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((65.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Brahmán" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((65.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((58.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((65.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((58.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Charolais" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((63.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((58.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((63.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((58.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Hereford" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((60.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((58.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((60.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((58.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Limousin" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((58.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((55.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((58.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((55.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Nelore" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((54.60/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((50.80/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((54.60/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((50.80/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Brow Swiss" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((51.29/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((51.29/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((51.29/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((51.29/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Holstein" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((56.41/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((56.07/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((56.41/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((56.07/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Normado" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((56.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((55.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((56.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((55.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Jersey" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((63.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((55.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((63.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((55.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

            "Gando de Lidia" -> {
                if(sexo == "Macho" && unidad == "Lb"){
                    var rendimiento: Double = (((62.45/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)
                }
                else if (sexo == "Hembra" && unidad == "Lb"){
                    var rendimiento: Double = (((58.00/100) * peso) * 2.20462)
                    resultado.text = (" Peso en Libras es " + rendimiento)

                }else if (sexo == "Macho" && unidad == "Kg"){
                    var rendimiento: Double = ((62.45/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)

                }else if (sexo == "Hembra" && unidad == "Kg"){
                    var rendimiento: Double = ((58.00/100) * peso)
                    resultado.text = ("Peso en Kilogramos es " + rendimiento)
                }
            }

        }

        /*



    }

    private fun Sumar(){
        /* Variables */
        val num1: EditText = findViewById(R.id.num1)
        var Sumando: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.num2)
        var Sumador: Double = num2.text.toString().toDouble()

        var suma: Double = Sumando + Sumador;

        val resultado:TextView = findViewById(R.id.resultado_suma)
        resultado.text = String.format("El Resultado de la Suma es: " + "%.3f",suma)
    }

    private fun Resta(){
        /* Variables */
        val num1: EditText = findViewById(R.id.num1)
        var Restando: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.num2)
        var Restador: Double = num2.text.toString().toDouble()

        var resta: Double = Restando - Restador

        val resultado:TextView = findViewById(R.id.resultado_resta)
        resultado.text = String.format("El Resultado de la Resta es: " + "%.3f",resta)
    }

    private fun Multiplicacion(){
        /* Variables */
        val num1: EditText = findViewById(R.id.num1)
        var Multiplicando: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.num2)
        var Multiplicador: Double = num2.text.toString().toDouble()

        var multiplicacion: Double = Multiplicando * Multiplicador

        val resultado:TextView = findViewById(R.id.resultado_multiplicacion)
        resultado.text = String.format("El Resultado de la Multiplicacion es: " + "%.3f",multiplicacion)
    }

    private fun Division(){
        /* Variables */
        val num1: EditText = findViewById(R.id.num1)
        var Dividiendo: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.num2)
        var Dividor: Double = num2.text.toString().toDouble()

        var Division: Double = Dividiendo - Dividor

        val resultado:TextView = findViewById(R.id.resultado_division)
        resultado.text = String.format("El Resultado de la division es: " + "%.3f",Division)

         */

    }
}