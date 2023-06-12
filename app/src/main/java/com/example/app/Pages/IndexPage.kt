package com.example.app.Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.app.R

class IndexPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index_page)

        val frameLayout: FrameLayout = findViewById(R.id.frame_layout)
        frameLayout.setOnClickListener{
            val intent: Intent = Intent(this, Page2::class.java)
            startActivity(intent)
        }
    }
}