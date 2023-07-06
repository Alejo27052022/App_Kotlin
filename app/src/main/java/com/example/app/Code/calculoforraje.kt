package com.example.app.Code

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class CalculoForraje : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forraje_animal)

        val buttonf: Button = findViewById(R.id.btn_calcforraje)
        buttonf.setOnClickListener {
            calcularforraje()
        }


    }
    private fun calcularforraje(){
        val constanteanimal =400
        val novillo:EditText = findViewById(R.id.numeroanimales)
        val n1: Double = novillo.text.toString().toDouble()
        val peso:EditText = findViewById(R.id.Peso)
        val n2: Double = peso.text.toString().toDouble()
        val calcHectareas:EditText = findViewById(R.id.hectareas)
        val n3: Double =calcHectareas.text.toString().toDouble()
        val unidadanimal =n2/constanteanimal
        val resultadounidad: TextView = findViewById(R.id.pesoresultadounidad)
        resultadounidad.text = String.format("%.2f",unidadanimal)
        val totalforraje=(unidadanimal*n1)/n3
        val resultadoforraje: TextView = findViewById(R.id.UAH)
        resultadoforraje.text = String.format("%.2f",totalforraje)




    }
}