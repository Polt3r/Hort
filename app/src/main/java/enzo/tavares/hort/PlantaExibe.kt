package enzo.tavares.hort

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import enzo.tavares.hort.Model.Planta
import enzo.tavares.hort.databinding.ActivityPlantaExibeBinding

class PlantaExibe : AppCompatActivity() {

    private lateinit var binding: ActivityPlantaExibeBinding

    var planta:Planta?=null
    lateinit var nome: TextView
    lateinit var nomeCientifico : TextView
    lateinit var descricao: TextView
    lateinit var foto : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantaExibeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, PlantioView::class.java)
            startActivity(anteriorTela)
        }

        nome = binding.nomePlanta as TextView
        nomeCientifico = binding.nomeCientifico as TextView
        descricao = binding.descricaoPlanta as TextView
        foto = binding.foto as ImageView

        this.planta = this.intent.getSerializableExtra("planta") as Planta
        preencherDados()


    }

    private fun preencherDados() {
        nome.setText(planta?.nome)
        nomeCientifico.setText(planta?.nomeCientifico)
        descricao.setText(planta?.descricao)
        Glide.with(this).load(planta?.foto).into(foto)
    }

}