package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.app.R

class IndexPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index_page)

        val frameLayout: ConstraintLayout = findViewById(R.id.frame_layout)
        frameLayout.setOnClickListener{
            val intent: Intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
    }
}