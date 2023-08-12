package com.example.app.Pages

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.R
import com.google.android.material.navigation.NavigationView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Reproduccion_Parto : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reproduccion_parto)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

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
