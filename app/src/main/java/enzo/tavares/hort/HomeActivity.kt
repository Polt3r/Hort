package enzo.tavares.hort

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import enzo.tavares.hort.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.receitas.setOnClickListener {
            val receitas = Intent(this, ReceitaView::class.java)
            startActivity(receitas)
        }

        binding.plantio.setOnClickListener {
            val categoria = Intent(this, CategoriaView::class.java)
            startActivity(categoria)
        }


    }


}