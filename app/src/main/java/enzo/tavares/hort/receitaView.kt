package enzo.tavares.hort

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import enzo.tavares.hort.Adapter.AdapterReceita
import enzo.tavares.hort.databinding.ActivityReceitasViewBinding

class receitaView : AppCompatActivity() {

    private lateinit var binding: ActivityReceitasViewBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Data_Receita>


    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>
    lateinit var tempoList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceitasViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val anteriorTela = Intent(this, HomeActivity::class.java)
            startActivity(anteriorTela)
        }



        imageList = arrayOf(
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next,
             R.drawable.btn_next)

        titleList = arrayOf(
            "Mousse de Maracujá",
            "Mousse de Morango",
            "Mousse de Uva",
            "Bolo de Chocolate",
            "Bolo de Cenoura",
            "Mousse de Maracujá",
            "Mousse de Morango",
            "Mousse de Uva",
            "Bolo de Chocolate",
            "Bolo de Cenoura"
        )

        tempoList = arrayOf(
            "5min",
            "5min",
            "5min",
            "30min",
            "60min",
            "5min",
            "5min",
            "5min",
            "30min",
            "60min",
        )

        recyclerView = binding.recycleReceitas
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<Data_Receita>()
        getData()


    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = Data_Receita(imageList[i], titleList[i], tempoList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterReceita(dataList)
    }

}