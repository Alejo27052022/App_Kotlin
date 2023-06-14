package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app.R

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val btn1: Button = findViewById(R.id.btn1)
        btn1.setOnClickListener{
            val intent: Intent = Intent(this, PesoCalculo::class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, RendimientoCalculo::class.java)
            startActivity(intent)
        }
    }
}