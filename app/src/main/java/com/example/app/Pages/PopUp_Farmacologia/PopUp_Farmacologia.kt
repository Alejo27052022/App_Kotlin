package com.example.app.Pages.PopUp_Farmacologia

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class PopUp_Farmacologia : AppCompatActivity(){

    private lateinit var autoComplete: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_farmacologia)



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

        autoComplete.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = autoComplete.text.toString()

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

                "Neomicina" -> {
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
}