package enzo.tavares.hort

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import enzo.tavares.hort.Adapter.AdapterReceita
import enzo.tavares.hort.Api.RetrofitClient
import enzo.tavares.hort.Model.Receita
import enzo.tavares.hort.databinding.ActivityReceitasViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReceitaView : AppCompatActivity() {

    private lateinit var binding: ActivityReceitasViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceitasViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, HomeActivity::class.java)
            startActivity(anteriorTela)
        }

        var RecyclerReceita = binding.recycleReceitas
        RecyclerReceita.layoutManager = LinearLayoutManager(this)



        val retroFitCli: RetrofitClient = RetrofitClient()
        retroFitCli.ReceitaService.getAllReceitas().enqueue(object : Callback<List<Receita>> {
            override fun onResponse(call: Call<List<Receita>>, response: Response<List<Receita>>) {
                if (response.isSuccessful) {
                    val receitas = response.body()
                    if(receitas !=null) {
                        val adapter: AdapterReceita =
                            AdapterReceita(this@ReceitaView, response.body()!!)
                        RecyclerReceita.adapter = adapter
                    }
                }
                else
                {
                    //Tratamento de erros
                }
            }

            override fun onFailure(call: Call<List<Receita>>, t: Throwable) {
                // Trate erros de rede ou qualquer outro erro ao fazer a chamada HTTP
                Log.e("retrofit", "onFailure: ",t )
            }

        })

    }

    override fun onResume() {
        super.onResume()
        var RecyclerReceita = binding.recycleReceitas
        RecyclerReceita.layoutManager = LinearLayoutManager(this)
        val retroFitCli: RetrofitClient = RetrofitClient()
        retroFitCli.ReceitaService.getAllReceitas().enqueue(object : Callback<List<Receita>> {
            override fun onResponse(call: Call<List<Receita>>, response: Response<List<Receita>>) {
                if (response.isSuccessful) {
                    val receitas = response.body()
                    if(receitas !=null) {
                        val adapter: AdapterReceita =
                            AdapterReceita(this@ReceitaView, response.body()!!)
                        RecyclerReceita.adapter = adapter
                    }
                }
                else
                {
                    //Tratamento de erros
                }
            }

            override fun onFailure(call: Call<List<Receita>>, t: Throwable) {
                // Trate erros de rede ou qualquer outro erro ao fazer a chamada HTTP
                Log.e("retrofit", "onFailure: ",t )
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==1 && resultCode==1)
        {

        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var RecyclerReceita = binding.recycleReceitas
        val adapter:AdapterReceita = RecyclerReceita.adapter as AdapterReceita
        val posicao:Int = adapter.posicaoClicada
        var receita:Receita? = null
        if (posicao >=0)
        {
            receita = adapter.listaReceita.get(posicao)
        }


        if(item.itemId==R.id.menu_item_editar)
        {
            if (receita!=null)
            {
                val intent:Intent = Intent(this, ReceitaExibe::class.java)
                intent.putExtra("receita",receita)
                startActivity(intent)
            }
        }


        return true
    }


}