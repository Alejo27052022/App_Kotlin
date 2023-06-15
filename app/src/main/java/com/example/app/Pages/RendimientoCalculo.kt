package com.example.app.Pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.app.R
import com.example.app.databinding.ActivityRendimientoCalculoBinding

class RendimientoCalculo : AppCompatActivity() {

    private lateinit var binding: ActivityRendimientoCalculoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRendimientoCalculoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("Aberdeen Angus", "Brahmán", "Charolais", "Hereford", "Limousin", "Nelore", "Brow Swiss", "Holstein", "Normado", "Jersey", "Gando de Lidia");
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        binding.dropdownMenuFieldRaza.setAdapter(adapter)

        val sexo = listOf("Macho", "Hembra")
        val adapter_sexo = ArrayAdapter(this, R.layout.list_item, sexo)
        binding.dropdownMenuFieldSexo.setAdapter(adapter_sexo)



    }
}