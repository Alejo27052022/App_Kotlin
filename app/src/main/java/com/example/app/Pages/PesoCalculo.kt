package com.example.app.Pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.app.R

class PesoCalculo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso_calculo)
        val button: Button = findViewById(R.id.btn_calcularpeso)
        button.setOnClickListener {
            calcularPeso()
        }


    }

    private fun calcularPeso() {
        val constantepeso = 10838
        val num1: EditText = findViewById(R.id.PTTEXT)
        val sumando: Double = num1.text.toString().toDouble()
        val num2: EditText = findViewById(R.id.LCTEXT)
        val sumador: Double = num2.text.toString().toDouble()
        val suma: Double = sumando * sumando * sumador / constantepeso
        val resultado: TextView = findViewById(R.id.pesoresultado)
        resultado.text = String.format("%.2f",suma)
        val libras:Double=suma*2.2
        val resultadolibras: TextView = findViewById(R.id.pesoresultadolibras)
        resultadolibras.text = String.format("%.2f",libras)
    }
}
