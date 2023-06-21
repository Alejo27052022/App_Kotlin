package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.app.R

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val home: ImageButton = findViewById(R.id.home_btn)
        val imgbtnManejo: ImageButton = findViewById(R.id.imgbtnManejo)

        btn1.setOnClickListener{
            val intent: Intent = Intent(this, PesoCalculo::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, RendimientoCalculo::class.java)
            startActivity(intent)
        }

        home.setOnClickListener{
            val intent: Intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        imgbtnManejo.setOnClickListener{
            val intent: Intent = Intent(this, Page2::class.java)
            startActivity(intent)
        }
    }
}