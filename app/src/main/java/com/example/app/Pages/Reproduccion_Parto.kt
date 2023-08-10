package com.example.app.Pages

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Reproduccion_Parto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reproduccion_parto)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.auto_complete)
        val fechaInseminacionTextView = findViewById<TextView>(R.id.fecha_inseminacion)

        val dbHelper = ayudaDb(this, null)
        val nombresCursor = dbHelper.getAllName()

        val nombresDeDatosDesdeLaBaseDeDatos = mutableListOf<String>()

        nombresCursor?.use { cursor ->
            while (cursor.moveToNext()) {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow(ayudaDb.COLUMN_NOMBRE))
                nombresDeDatosDesdeLaBaseDeDatos.add(nombre)
            }
        }

        nombresCursor?.close()

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, nombresDeDatosDesdeLaBaseDeDatos)
        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedName = parent.getItemAtPosition(position) as String
            val dbHelper = ayudaDb(this, null)

            val nombresCursor = dbHelper.getAllName()

            var selectedDate: String? = null
            nombresCursor?.use { cursor ->
                while (cursor.moveToNext()) {
                    val nombre = cursor.getString(cursor.getColumnIndexOrThrow(ayudaDb.COLUMN_NOMBRE))
                    val fecha = cursor.getString(cursor.getColumnIndexOrThrow(ayudaDb.COLUMN_FECHA))

                    if (nombre == selectedName) {
                        selectedDate = fecha
                        break
                    }
                }
            }

            nombresCursor?.close()

            // Actualiza el TextView con la fecha de inseminación correspondiente
            fechaInseminacionTextView.text = selectedDate
        }

        val calcular_fecha: Button = findViewById(R.id.calcular_fecha)
        calcular_fecha.setOnClickListener {
            val fechaInseminacionTextView = findViewById<TextView>(R.id.fecha_inseminacion)
            val fechaPartoTextView = findViewById<TextView>(R.id.fecha_parto)

            val dateFormatDatabase = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateFormatOutput = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            val inseminationDateStr = fechaInseminacionTextView.text.toString()
            try {
                val inseminationDate = dateFormatDatabase.parse(inseminationDateStr)

                val calendar = Calendar.getInstance()
                calendar.timeInMillis = inseminationDate.time
                calendar.add(Calendar.DAY_OF_MONTH, 283)

                val calculatedDueDate = dateFormatOutput.format(calendar.time)

                fechaPartoTextView.text = calculatedDueDate
            } catch (e: ParseException) {
                // Manejar la excepción en caso de error al analizar la fecha
                e.printStackTrace()
            }
        }
    }

}
