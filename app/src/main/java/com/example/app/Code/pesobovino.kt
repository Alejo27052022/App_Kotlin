package com.example.app.Code
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class MainActivity : AppCompatActivity() {
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
        val suma: Double = sumando*sumando * sumador/constantepeso

        val resultado: TextView = findViewById(R.id.pesoresultado)
        resultado.text = String.format("%.3f", suma)
    }
}


