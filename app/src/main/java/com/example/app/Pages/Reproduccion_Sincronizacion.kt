package com.example.app.Pages

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.google.android.material.navigation.NavigationView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Reproduccion_Sincronizacion : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var resultadoTextView: TextView
    private lateinit var fechaButton: ImageButton
    private lateinit var horaButton: ImageButton
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private var fechaIngreso: String = ""
    private var horaIngreso: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reproduccion_sincronizacion)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        resultadoTextView = findViewById(R.id.resultadoTextView)
        fechaButton = findViewById(R.id.fechaButton)
        horaButton = findViewById(R.id.horaButton)

    }

    fun calcularButtonOnClick(view: View) {
        resultadoTextView.text = ""

        val fechaHoraRetiro = calcularFechaHoraRetiro(fechaIngreso, horaIngreso)
        val fechaHoraIATF = calcularFechaHoraIATF(fechaHoraRetiro)

        resultadoTextView.append("Actividad: Retirar el dispositivo DIB \nFecha: $fechaHoraRetiro\n")
        administrarMedicamento("PGF2alfa 2ml", fechaHoraRetiro)
        administrarMedicamento("ECP 0,5 mg", fechaHoraRetiro)
        administrarMedicamento("ECG 200 UI", fechaHoraRetiro)

        resultadoTextView.append("\nActividad: IATF (Inseminación Artificial a Tiempo Fijo)\nFecha: $fechaHoraIATF  \n")
        administrarMedicamento("GNRH 2ml", fechaHoraIATF)
    }

    fun fechaButtonOnClick(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, R.style.DatePickerDialogTheme,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                fechaIngreso = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDayOfMonth)
                fechaButton.txt = "Fecha seleccionada: $fechaIngreso"
            }, year, month, dayOfMonth)

        datePickerDialog.show()
    }

    fun horaButtonOnClick(view: View) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, R.style.MyTimePickerDialogTheme,
            TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                horaIngreso = String.format("%02d:%02d", selectedHour, selectedMinute)
                horaButton.text = "Hora seleccionada: $horaIngreso"
            }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun calcularFechaHoraRetiro(fechaIngreso: String, horaIngreso: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val calendar = Calendar.getInstance()

        try {
            val fechaHora = sdf.parse("$fechaIngreso ${this.horaIngreso}")

            calendar.time = fechaHora
            calendar.add(Calendar.DAY_OF_MONTH, 8)

            val nuevaFechaHora = calendar.time

            return sdf.format(nuevaFechaHora)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    private fun calcularFechaHoraIATF(fechaHoraRetiro: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val calendar = Calendar.getInstance()

        try {
            val fechaHora = sdf.parse(fechaHoraRetiro)

            calendar.time = fechaHora
            calendar.add(Calendar.DAY_OF_MONTH, 2)

            val nuevaFechaHora = calendar.time



            return sdf.format(nuevaFechaHora)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    private fun administrarMedicamento(medicamento: String, fechaHora: String) {
        resultadoTextView.append("Administrar: $medicamento\n")
    }

    fun retroceder(view: View) {
        onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.home_option -> {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
            R.id.farmacologia_option -> Toast.makeText(this, "Farmacologia", Toast.LENGTH_SHORT).show()
            R.id.nutricion_option -> Toast.makeText(this, "Nutricion", Toast.LENGTH_SHORT).show()
            R.id.manejo_option -> {
                val intent = Intent(this, Manejo_Inicio::class.java)
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