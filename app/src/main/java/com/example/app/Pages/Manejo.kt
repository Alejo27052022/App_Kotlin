package com.example.app.Pages

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.app.R

class Manejo : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manejo)

        val pastoreo : ConstraintLayout = findViewById(R.id.pastoreo)
        val ordeno : ConstraintLayout = findViewById(R.id.ordeno)
        val manejo : ConstraintLayout = findViewById(R.id.manejo)
        val comportamiento : ConstraintLayout = findViewById(R.id.comportamiento)
        val canal : ConstraintLayout = findViewById(R.id.canal)
        val bienestar : ConstraintLayout = findViewById(R.id.bienestar)

    }
}