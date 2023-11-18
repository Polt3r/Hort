package enzo.tavares.hort

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import enzo.tavares.hort.databinding.ActivityCategoriaViewBinding

class CategoriaView : AppCompatActivity() {

    lateinit var binding: ActivityCategoriaViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, HomeActivity::class.java)
            startActivity(anteriorTela)
        }

        binding.frutas.setOnClickListener {
            val frutasView = Intent(this, PlantioView::class.java)
            frutasView.putExtra("filtro","Frutas")
            startActivity(frutasView)
        }

        binding.vegetais.setOnClickListener {
            val vegetaisView = Intent(this, PlantioView::class.java)
            vegetaisView.putExtra("filtro","Vegetais")
            startActivity(vegetaisView)
        }

        binding.graos.setOnClickListener {
            val graosView = Intent(this, PlantioView::class.java)
            graosView.putExtra("filtro","Graos")
            startActivity(graosView)
        }



    }
}