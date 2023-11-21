package enzo.tavares.hort

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import enzo.tavares.hort.Model.Receita
import enzo.tavares.hort.databinding.ActivityPlantioViewBinding
import enzo.tavares.hort.databinding.ActivityReceitaExibeBinding

class ReceitaExibe : AppCompatActivity() {

    private lateinit var binding: ActivityReceitaExibeBinding

    var receita:Receita?= null
    lateinit var nome: TextView
    lateinit var tempoDePreparo : TextView
    lateinit var ingredientes: TextView
    lateinit var modoDePreparo : TextView
    lateinit var foto : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceitaExibeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, ReceitaView::class.java)
            startActivity(anteriorTela)
        }

        nome = binding.nomeReceita as TextView
        tempoDePreparo = binding.tempoDePreparo as TextView
        ingredientes = binding.ingredientes as TextView
        modoDePreparo = binding.preparo as TextView
        foto = binding.fotoReceita as ImageView

        this.receita = this.intent.getSerializableExtra("receita") as Receita
        preencherDados()


    }

    private fun preencherDados() {
        nome.setText(receita?.nome)
        tempoDePreparo.setText(receita?.tempoDePreparo)
        ingredientes.setText(receita?.ingredientes)
        modoDePreparo.setText(receita?.modoDePreparo)
        Glide.with(this).load(receita?.foto).into(foto)

    }
}