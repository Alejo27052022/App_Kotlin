package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.app.R

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val imgbtnManejo: ImageButton = findViewById(R.id.imgbtnManejo)
        val home: ImageButton = findViewById(R.id.home_btn)

        imgbtnManejo.setOnClickListener{
            val intent: Intent = Intent(this, Manejo::class.java)
            startActivity(intent)
        }

        home.setOnClickListener{
            val intent: Intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

    }
}