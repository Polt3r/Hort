package enzo.tavares.hort

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import enzo.tavares.hort.Adapter.AdapterPlanta
import enzo.tavares.hort.Api.RetrofitClient
import enzo.tavares.hort.Model.Planta
import enzo.tavares.hort.databinding.ActivityPlantioViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantioView : AppCompatActivity() {

    private lateinit var binding: ActivityPlantioViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantioViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, CategoriaView::class.java)
            startActivity(anteriorTela)
        }

        var RecyclerPlanta = binding.recyclerView
        RecyclerPlanta.layoutManager = LinearLayoutManager(this)

        recuperaDados()

        val retrofitCli: RetrofitClient = RetrofitClient();
        retrofitCli.PlantaService.getAllAlimentos().enqueue(object : Callback<List<Planta>> {
            override fun onResponse(call: Call<List<Planta>>, response: Response<List<Planta>>) {
                if (response.isSuccessful) {
                    val plantas = response.body()
                    if(plantas !=null)
                    {
                        val adapter:AdapterPlanta= AdapterPlanta(this@PlantioView, response.body()!!)
                        RecyclerPlanta.adapter = adapter
                    }
                }
                else
                {
                    // Trate erros de resposta, como 404, 500 etc.
                }
            }

            override fun onFailure(call: Call<List<Planta>>, t: Throwable) {
                // Trate erros de rede ou qualquer outro erro ao fazer a chamada HTTP
                Log.e("retrofit", "onFailure: ",t )
            }

        })

    }

    override fun onResume() {
        super.onResume()
        var RecyclerPlanta = binding.recyclerView
        RecyclerPlanta.layoutManager = LinearLayoutManager(this)
        val retrofitCli: RetrofitClient = RetrofitClient();
        retrofitCli.PlantaService.getAllAlimentos().enqueue(object : Callback<List<Planta>> {
            override fun onResponse(call: Call<List<Planta>>, response: Response<List<Planta>>) {
                if (response.isSuccessful) {
                    val plantas = response.body()
                    if(plantas !=null)
                    {
                        val adapter:AdapterPlanta= AdapterPlanta(this@PlantioView, response.body()!!)
                        RecyclerPlanta.adapter = adapter


                    }
                }
                else
                {
                    // Trate erros de resposta, como 404, 500 etc.
                }
            }

            override fun onFailure(call: Call<List<Planta>>, t: Throwable) {
                // Trate erros de rede ou qualquer outro erro ao fazer a chamada HTTP
                Log.e("retrofit", "onFailure: ",t )
            }
        })
    }

    private fun recuperaDados() {

        val filtro = intent.getStringExtra("filtro")

        binding.plantioCategoria.setText(filtro)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var RecyclerPlanta = binding.recyclerView
        val adapter:AdapterPlanta = RecyclerPlanta.adapter as AdapterPlanta
        val posicao:Int = adapter.posicaoClicada
        var planta:Planta? = null
        if (posicao >=0)
        {
            planta = adapter.listaPlanta.get(posicao)
        }


        if(item.itemId==R.id.menuPlantioAbri)
        {
            if (planta!=null)
            {
                val intent:Intent = Intent(this, PlantaExibe::class.java)
                intent.putExtra("planta",planta)
                startActivity(intent)
            }
        }


        return true
    }


}